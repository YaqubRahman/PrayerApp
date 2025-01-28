package com.example.prayerapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SalahClient {
    fun getApi(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl("https://www.londonprayertimes.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
    }
}

// times/?format=json&key=4498bab9-2013-4567-a401-58ff5427a02e&year=2025&month=july&24hours=true