package com.example.ricimority.data.network.apiservices

import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.character.Charactermodel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactorApi {

    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int
    ): RickAndMortyResponse<Charactermodel>

    @GET("api/character/{id}")
     fun getCharacter(
        @Path("id") id: Int
    ): Call<Charactermodel>
}