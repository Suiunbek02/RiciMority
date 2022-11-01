package com.example.ricimority.repositories

import androidx.lifecycle.MutableLiveData
import com.example.ricimority.App
import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.episode.EpisodeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryEpisode {

    val data: MutableLiveData<RickAndMortyResponse<EpisodeModel>> = MutableLiveData()

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        App.episodeApi?.fetchEpisode()
            ?.enqueue(object : Callback<RickAndMortyResponse<EpisodeModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    response: Response<RickAndMortyResponse<EpisodeModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}


