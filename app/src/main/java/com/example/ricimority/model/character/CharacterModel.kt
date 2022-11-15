package com.example.ricimority.model.character

import androidx.room.PrimaryKey
import com.example.ricimority.base.IBaseDiffUtil
import com.google.gson.annotations.SerializedName

data class CharacterModel(

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

    @SerializedName("origin")
    val origin: Origin,

    @SerializedName("location")
    val location: Location
) : IBaseDiffUtil
