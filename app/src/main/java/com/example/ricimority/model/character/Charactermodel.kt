package com.example.ricimority.model.character

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ricimority.base.IBaseDiffUtill
import com.google.gson.annotations.SerializedName

@Entity(tableName = "character")
data class Charactermodel(

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
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
    val gender: String
) : IBaseDiffUtill
