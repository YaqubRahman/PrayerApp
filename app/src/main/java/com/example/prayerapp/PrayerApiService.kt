package com.example.prayerapp

import retrofit2.Call
import retrofit2.http.GET

// const val BASE_URL = "https://jsonplaceholder.typicode.com/"
// const val = "posts"
interface PrayerApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}
