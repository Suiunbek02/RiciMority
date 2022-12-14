package com.example.ricimority.data.repositoryes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.ricimority.data.network.apiservices.LocationApi
import com.example.ricimority.data.repositoryes.pagingsources.LocationPagingSources
import com.example.ricimority.model.location.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val locationApi: LocationApi
) {

    fun fetchLocation(): LiveData<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                LocationPagingSources(locationApi)
            }, initialKey = 1
        ).liveData
    }

    val data: MutableLiveData<LocationModel> = MutableLiveData()

    fun fetchDetailLocation(id: Int): MutableLiveData<LocationModel> {
        locationApi.fetchDetailLocation(id).enqueue(
            object : Callback<LocationModel> {
                override fun onResponse(
                    call: Call<LocationModel>,
                    response: Response<LocationModel>
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<LocationModel>,
                    t: Throwable
                ) {
                }

            })
        return data
    }
}
