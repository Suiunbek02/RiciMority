package com.example.ricimority

import android.app.Application
import androidx.room.Room
import com.example.ricimority.data.db.AppDatabase
import com.example.ricimority.data.network.apiservices.CharactorApi
import com.example.ricimority.data.network.apiservices.EpisodeApi
import com.example.ricimority.data.network.apiservices.LocationApi
import com.example.ricimority.data.network.apiservices.RetrofitClient

class App : Application() {

    companion object {
        private val retrofitClient = RetrofitClient()
        var charactorApi: CharactorApi? = null
        var episodeApi: EpisodeApi? = null
        var locationApi: LocationApi? = null
        var appDatabase: AppDatabase? = null
    }

    private fun instanceOfRoom(): AppDatabase? {
        if (appDatabase == null) {
            appDatabase = applicationContext?.let {
                Room.databaseBuilder(
                    it,
                    AppDatabase::class.java,
                    "note_database"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
        }
        return appDatabase
    }

    override fun onCreate() {
        super.onCreate()
        charactorApi = retrofitClient.providerCherecterApiService()
        episodeApi = retrofitClient.providerEpisodeApiService()
        locationApi = retrofitClient.providerLocationApiService()
        instanceOfRoom()
    }
}