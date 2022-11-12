package com.example.ricimority.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.ricimority.App
import com.example.ricimority.data.network.apiservices.EpisodeApi
import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.episode.EpisodeModel
import com.example.ricimority.repositories.pagingsources.EpisodePagingSources
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RepositoryEpisode @Inject constructor(
    private val episodeApi: EpisodeApi
) {

    fun fetchEpisode(): LiveData<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                EpisodePagingSources(episodeApi)
            }, initialKey = 1
        ).liveData
    }

    val data: MutableLiveData<EpisodeModel> = MutableLiveData()

    fun getEpisode(id: Int): MutableLiveData<EpisodeModel> {
        episodeApi.getEpisode(id) .enqueue(
            object : Callback<EpisodeModel> {
            override fun onResponse(
                call: Call<EpisodeModel>,
                response: Response<EpisodeModel>
            ){
                response.body()?.let {
                    data.value = it
                }
            }

            override fun onFailure(
                call: Call<EpisodeModel>,
                t: Throwable) {
            }

        })
        return data
    }
}


