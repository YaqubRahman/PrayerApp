package com.example.prayerapp

import retrofit2.Call
import retrofit2.http.GET

// const val BASE_URL = "https://jsonplaceholder.typicode.com/"
// const val = "posts" GET /timings/27-01-2025
interface PrayerApiService {
    @GET("timings/{date}?latitude=51.5194682&longitude=-0.1360365&method=3&shafaq=general&tune=5%2C13%2C5%2C5%2C2%2C4%2C0%2C8%2C-6&timezonestring=Europe%2FLondon&calendarMethod=UAQ")
    //@GET("timings/29-03-2025?latitude=51.5194682&longitude=-0.1360365&method=3&shafaq=general&tune=5%2C13%2C5%2C5%2C2%2C4%2C0%2C8%2C-6&timezonestring=UTC&calendarMethod=UAQ")
    fun getSalah(): Call<PrayerApiResponse>
}