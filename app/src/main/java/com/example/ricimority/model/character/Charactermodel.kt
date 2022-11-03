package com.example.ricimority.model.character

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.ricimority.base.IBaseDiffUtill
import com.example.ricimority.data.db.converters.Converters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "character")
data class Charactermodel(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("created")
    val created: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("gender")
    val gender: String,

    @TypeConverters(Converters::class)
    @SerializedName("origin")
    val origin: Origin,

    @TypeConverters(Converters::class)
    @SerializedName("location")
    val location: Location
) : IBaseDiffUtill
