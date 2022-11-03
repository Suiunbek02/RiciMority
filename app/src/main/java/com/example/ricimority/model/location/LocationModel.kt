package com.example.ricimority.model.location

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ricimority.base.IBaseDiffUtill
import com.google.gson.annotations.SerializedName

@Entity(tableName = "location")
data class LocationModel(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("created")
    val created: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("dimension")
    val dimension: String?
): IBaseDiffUtill
