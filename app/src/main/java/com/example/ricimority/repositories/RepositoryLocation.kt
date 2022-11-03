package com.example.ricimority.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ricimority.App
import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.location.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryLocation {

    val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        App.locationApi?.fetchLocation()
            ?.enqueue(object : Callback<RickAndMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>
                ) {
                    response.body()?.let {
                        App.appDatabase?.locationDao()?.insertList(it.results)
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    t: Throwable
                ) {

                }
            })
        return data
    }

    fun getLocation(): LiveData<List<LocationModel>> {
        return App.appDatabase?.locationDao()?.getAllList()!!
    }
}
