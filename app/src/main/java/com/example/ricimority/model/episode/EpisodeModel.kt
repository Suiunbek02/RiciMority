package com.example.ricimority.model.episode

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ricimority.base.IBaseDiffUtil
import com.google.gson.annotations.SerializedName

@Entity(tableName = "episode")
data class EpisodeModel(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("air_date")
    val airDate: String?,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String,
): IBaseDiffUtil
