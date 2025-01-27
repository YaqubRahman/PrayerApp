package com.example.prayerapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostClient {
    fun getApi(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
    }
}

