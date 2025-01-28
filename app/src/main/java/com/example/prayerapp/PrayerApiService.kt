package com.example.prayerapp

import retrofit2.Call
import retrofit2.http.GET

// const val BASE_URL = "https://jsonplaceholder.typicode.com/"
// const val = "posts" GET /timings/27-01-2025
interface PrayerApiService {
    @GET("times/?format=json&key=4498bab9-2013-4567-a401-58ff5427a02e&year=2025&month=july&24hours=true")
    fun getSalah(): Call<PrayerApiResponse>
}


