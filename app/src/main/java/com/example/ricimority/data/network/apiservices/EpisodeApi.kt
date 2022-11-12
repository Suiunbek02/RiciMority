package com.example.ricimority.data.network.apiservices

import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.episode.EpisodeModel
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApi {

     @GET("api/character")
     suspend fun fetchEpisode(
          @Query("page") page: Int
     ): RickAndMortyResponse<EpisodeModel>

     @GET("api/character/{id}")
     fun getEpisode(
          @Path("id") id: Int
     ): Call<EpisodeModel>
}