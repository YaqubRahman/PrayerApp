package com.example.prayerapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SalahClient {
    fun getApi(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl("https://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
    }
}

//https://api.aladhan.com/v1/



//https://aladhan.com/prayer-times-api#get-/timings/