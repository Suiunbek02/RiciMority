package com.example.ricimority.model.location

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("created")
    val created: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("dimension")
    val dimension: String
)
