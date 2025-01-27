package com.example.prayerapp

import retrofit2.Call
import retrofit2.http.GET

// const val BASE_URL = "https://jsonplaceholder.typicode.com/"
// const val = "posts" GET /timings/27-01-2025
interface PrayerApiService {
    @GET("timingsByCity/01-01-2025?city=London&country=GB")
    fun getSalah(): Call<PrayerApiResponse>
}
