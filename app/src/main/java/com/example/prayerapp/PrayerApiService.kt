package com.example.prayerapp

import retrofit2.http.GET
import retrofit2.http.Path

interface PrayerApiService {
    @GET("timings/{date}")
    suspend fun getPrayerTimes(@Path("date") date: String): PrayerApiResponse
}

