package com.example.ricimority.data.repositoryes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.ricimority.data.network.apiservices.EpisodeApi
import com.example.ricimority.data.repositoryes.pagingsources.EpisodePagingSources
import com.example.ricimority.model.episode.EpisodeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
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

    fun fetchDetailEpisode(id: Int): MutableLiveData<EpisodeModel> {
        episodeApi.fetchDetailEpisode(id).enqueue(
            object : Callback<EpisodeModel> {
                override fun onResponse(
                    call: Call<EpisodeModel>,
                    response: Response<EpisodeModel>
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<EpisodeModel>,
                    t: Throwable
                ) {
                }

            })
        return data
    }
}


