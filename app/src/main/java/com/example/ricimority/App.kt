package com.example.ricimority

import android.app.Application
import androidx.room.Room
import com.example.ricimority.data.db.AppDatabase
import com.example.ricimority.data.network.apiservices.CharactorApi
import com.example.ricimority.data.network.apiservices.EpisodeApi
import com.example.ricimority.data.network.apiservices.LocationApi
import com.example.ricimority.data.network.apiservices.RetrofitClient
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltAndroidApp
class App : Application() {
}