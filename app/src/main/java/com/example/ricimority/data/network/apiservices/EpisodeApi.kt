package com.example.ricimority.data.network.apiservices

import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.episode.EpisodeModel
import retrofit2.http.GET
import retrofit2.Call

interface EpisodeApi {

     @GET("api/character")
     fun fetchEpisode(): Call<RickAndMortyResponse<EpisodeModel>>
}