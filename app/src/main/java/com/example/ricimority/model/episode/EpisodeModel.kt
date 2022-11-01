package com.example.ricimority.model.episode

import com.google.gson.annotations.SerializedName

data class EpisodeModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("air_date")
    val airDate: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String,
)
