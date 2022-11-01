package com.example.ricimority.data.network.apiservices

import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.location.LocationModel
import retrofit2.Call
import retrofit2.http.GET

interface LocationApi {

    @GET("api/character")
    fun fetchLocation(): Call<RickAndMortyResponse<LocationModel>>
}