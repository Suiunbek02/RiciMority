package com.example.ricimority.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ricimority.model.character.Charactermodel

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character")
    fun getAllList(): LiveData<List<Charactermodel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<Charactermodel>)

}