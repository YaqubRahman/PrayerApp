package com.example.prayerapp

import retrofit2.http.GET

interface PrayerApiService {
    @GET("https://api.aladhan.com/v1")
    suspend fun getPrayerTimes(): List<PrayerTime>
}
