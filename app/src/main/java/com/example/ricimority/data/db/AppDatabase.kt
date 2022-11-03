package com.example.ricimority.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ricimority.data.db.converters.Converters
import com.example.ricimority.data.db.daos.CharacterDao
import com.example.ricimority.data.db.daos.EpisodeDao
import com.example.ricimority.data.db.daos.LocationDao
import com.example.ricimority.model.character.Charactermodel
import com.example.ricimority.model.episode.EpisodeModel
import com.example.ricimority.model.location.LocationModel

@Database(entities = [Charactermodel::class, EpisodeModel::class, LocationModel::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    abstract fun episodeDao(): EpisodeDao

    abstract fun locationDao(): LocationDao
}