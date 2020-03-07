package com.samir.weatherlogger.data.provider

import com.samir.weatherlogger.data.db.WeatherLocationEntry


interface LocationProvider {
    suspend fun hasLocationChanged(lastWeatherLocation: WeatherLocationEntry): Boolean
    suspend fun getPreferredLocationString(): String

}
