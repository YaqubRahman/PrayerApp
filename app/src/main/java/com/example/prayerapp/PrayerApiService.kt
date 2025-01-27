package com.example.prayerapp

import retrofit2.http.GET

interface PrayerApiService {
    @GET("timings/2025-01-26/51.5194682/-0.1360365")
    suspend fun getPrayerTimes(): PrayerApiResponse
}
