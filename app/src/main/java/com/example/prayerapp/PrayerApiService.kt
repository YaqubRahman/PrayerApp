package com.example.prayerapp

import retrofit2.http.GET

interface PrayerApiService {
    @GET("timings/2025-01-26")
    suspend fun getPrayerTimes(): PrayerApiResponse
}
