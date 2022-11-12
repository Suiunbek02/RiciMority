package com.example.ricimority.data.network.apiservices

import com.example.ricimority.model.RickAndMortyResponse
import com.example.ricimority.model.location.LocationModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApi {

    @GET("api/character")
    suspend fun fetchLocation(
        @Query("page") page : Int
    ): RickAndMortyResponse<LocationModel>

    @GET("api/character/{id}")
    fun getLocation(
        @Path("id") id: Int
    ): Call<LocationModel>
}