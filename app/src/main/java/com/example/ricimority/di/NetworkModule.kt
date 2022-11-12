package com.example.ricimority.di

import com.example.ricimority.data.network.apiservices.CharactorApi
import com.example.ricimority.data.network.apiservices.EpisodeApi
import com.example.ricimority.data.network.apiservices.LocationApi
import com.example.ricimority.data.network.apiservices.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    private var retrofit = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharacterApi(): CharactorApi {
        return retrofit.providerCherecterApiService()
    }

    @Singleton
    private var retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideEpisodeApi(): EpisodeApi {
        return retrofitClient.providerEpisodeApiService()
    }

    @Singleton
    private var retrofitClientLocation = RetrofitClient()

    @Singleton
    @Provides
    fun provideLocationApi(): LocationApi {
        return retrofitClientLocation.providerLocationApiService()
    }

}