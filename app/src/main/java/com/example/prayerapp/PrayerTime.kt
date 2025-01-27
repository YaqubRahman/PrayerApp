package com.example.prayerapp

data class PrayerApiResponse(
    val code: Int,
    val status: String,
    val data: PrayerData
)

data class PrayerData(
    val timings: Timings,
    val date: Date,
    val meta: Meta
)

data class Timings(
    val Fajr: String,
    val Sunrise: String,
    val Dhuhr: String,
    val Asr: String,
    val Sunset: String,
    val Maghrib: String,
    val Isha: String,
    val Imsak: String,
    val Midnight: String,
    val Firstthird: String,
    val Lastthird: String
)

data class Date(
    val readable: String,
    val timestamp: Long,
    val hijri: HijriDate,
    val gregorian: GregorianDate
)

data class HijriDate(
    val date: String,
    val format: String,
    val day: Int,
    val weekday: Weekday,
    val month: HijriMonth,
    val year: String,
    val designation: Designation,
    val holidays: List<String>
)

data class GregorianDate(
    val date: String,
    val format: String,
    val day: Int,
    val weekday: Weekday,
    val month: GregorianMonth,
    val year: Int,
    val designation: Designation,
    val lunarSighting: Boolean
)

data class Weekday(
    val en: String,
    val ar: String
)

data class HijriMonth(
    val number: Int,
    val en: String,
    val ar: String,
    val days: Int
)

data class GregorianMonth(
    val number: Int,
    val en: String
)

data class Designation(
    val abbreviated: String,
    val expanded: String
)

data class Meta(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val method: Method,
    val latitudeAdjustmentMethod: String,
    val midnightMode: String,
    val school: String,
    val offset: PrayerOffset
)

data class Method(
    val id: Int,
    val name: String,
    val params: MethodParams,
    val location: Location
)

data class MethodParams(
    val Fajr: Int,
    val Isha: Int
)

data class Location(
    val latitude: Double,
    val longitude: Double
)

data class PrayerOffset(
    val Imsak: Int,
    val Fajr: Int,
    val Sunrise: Int,
    val Dhuhr: Int,
    val Asr: Int,
    val Sunset: Int,
    val Maghrib: Int,
    val Isha: Int,
    val Midnight: Int
)
