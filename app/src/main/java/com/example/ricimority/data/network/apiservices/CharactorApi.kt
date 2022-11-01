package com.example.ricimority.data.network.apiservices

import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.character.Charactermodel
import retrofit2.Call
import retrofit2.http.GET

interface CharactorApi {

    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<Charactermodel>>
}