package com.example.prayerapp

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userId")
    val UserId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)
