package com.example.ricimority.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ricimority.model.location.LocationModel

@Dao
interface LocationDao {

    @Query("SELECT * FROM location")
    fun getAllList(): LiveData<List<LocationModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<LocationModel>)
}