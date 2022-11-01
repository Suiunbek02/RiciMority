package com.example.ricimority.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ricimority.data.db.daos.CharacterDao
import com.example.ricimority.model.character.Charactermodel

@Database(entities = [Charactermodel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}