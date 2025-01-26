package com.example.prayerapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class PrayerViewModel : ViewModel() {

    private val _prayerTimes = MutableStateFlow<PrayerApiResponse?>(null)
    val prayerTimes: StateFlow<PrayerApiResponse?> = _prayerTimes

    init {
        fetchPrayerTimes()
    }

    private fun fetchPrayerTimes() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPrayerTimes()
                _prayerTimes.value = response
            } catch (e: HttpException) {
                // Handle API call failure
                _prayerTimes.value = null // Set to null in case of an error
            } catch (e: IOException) {
                // Handle network failure
                _prayerTimes.value = null // Set to null in case of an error
            }
        }
    }
}
