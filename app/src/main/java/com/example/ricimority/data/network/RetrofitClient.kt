package com.example.ricimority.data.network

import com.example.ricimority.data.network.apiservices.CharacterApi
import com.example.ricimority.data.network.apiservices.EpisodeApi
import com.example.ricimority.data.network.apiservices.LocationApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class  RetrofitClient {

    private val okHttpClient: OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(provideInspector())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build()

    private fun provideInspector(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun providerCharacterApiService(): CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }

    fun providerEpisodeApiService(): EpisodeApi {
        return retrofit.create(EpisodeApi::class.java)
    }

    fun providerLocationApiService(): LocationApi {
        return retrofit.create(LocationApi::class.java)
    }
}