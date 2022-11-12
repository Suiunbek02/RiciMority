package com.example.ricimority.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.ricimority.App
import com.example.ricimority.data.network.apiservices.EpisodeApi
import com.example.ricimority.data.network.apiservices.LocationApi
import com.example.ricimority.model.episode.EpisodeModel
import com.example.ricimority.model.location.LocationModel
import com.example.ricimority.repositories.pagingsources.LocationPagingSources
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RepositoryLocation @Inject constructor(
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

    fun getLocation(id: Int): MutableLiveData<LocationModel> {
        locationApi.getLocation(id) .enqueue(
            object : Callback<LocationModel> {
                override fun onResponse(
                    call: Call<LocationModel>,
                    response: Response<LocationModel>
                ){
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<LocationModel>,
                    t: Throwable) {
                }

            })
        return data
    }
}
