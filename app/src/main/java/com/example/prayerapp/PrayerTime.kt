package com.example.prayerapp

data class PrayerApiResponse(
    val city: String,
    val times: Map<String, PrayerDay>
)

data class PrayerDay(
    val date: String,
    val fajr: String,
    val fajr_jamat: String,
    val sunrise: String,
    val dhuhr: String,
    val dhuhr_jamat: String,
    val asr: String,
    val asr_2: String,
    val asr_jamat: String,
    val magrib: String,
    val magrib_jamat: String,
    val isha: String,
    val isha_jamat: String
)
