package com.example.prayerapp

import retrofit2.http.GET

interface PrayerApiService {
    @GET("v1")
    suspend fun getPrayerTimes(): PrayerApiResponse
}
