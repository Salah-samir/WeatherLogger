package com.samir.weatherlogger.data.network

import androidx.lifecycle.LiveData
import com.samir.weatherlogger.data.network.response.WeatherResponse

interface WeatherNetworkDataSource {
    val downloadedWeather : LiveData<WeatherResponse>
    suspend fun fetchWeather(
        location: String,UNITS: String, lang: String,apiKey:String
    )
}
