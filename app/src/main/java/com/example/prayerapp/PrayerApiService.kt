package com.example.prayerapp

import retrofit2.Call
import retrofit2.http.GET

// const val BASE_URL = "https://jsonplaceholder.typicode.com/"
// const val = "posts" GET /timings/27-01-2025
interface PrayerApiService {
    @GET("timingsByAddress/01-01-2025?address=Trafalgar+Square%2C+London%2C+UK&x7xapikey=P244d623e2fe2daf56359fGyK3s&method=3&shafaq=general&tune=5%2C3%2C5%2C7%2C9%2C-1%2C0%2C8%2C-6&timezonestring=UTC&calendarMethod=UAQ")
    fun getSalah(): Call<PrayerApiResponse>
}
