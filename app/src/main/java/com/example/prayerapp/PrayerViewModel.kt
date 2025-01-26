package com.example.prayerapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class PrayerViewModel : ViewModel() {

    val _error = MutableStateFlow<String?>(null)
    val _prayerTimes = MutableStateFlow<PrayerApiResponse?>(null)

    init {
        fetchPrayerTimes()
    }

    private fun fetchPrayerTimes() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPrayerTimes()
                _prayerTimes.value = response
                _error.value = null // Clear any previous errors on success
            } catch (e: HttpException) {
                // Log the HTTP status code and the response body for debugging
                _prayerTimes.value = null
                _error.value = "API Error: ${e.code()} - ${e.message()}"
                // You can also log the response body if needed (e.g., for more detailed error information)
                try {
                    val errorBody = e.response()?.errorBody()?.string()
                    Log.e("PrayerViewModel", "Error body: $errorBody")
                } catch (ex: Exception) {
                    Log.e("PrayerViewModel", "Error parsing error body", ex)
                }
            } catch (e: IOException) {
                // Handle network failure
                _prayerTimes.value = null
                _error.value = "Network Error: ${e.localizedMessage}"
            }
        }
    }
}