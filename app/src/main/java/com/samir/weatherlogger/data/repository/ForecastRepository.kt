package com.samir.weatherlogger.data.repository

import androidx.lifecycle.LiveData
import com.samir.weatherlogger.data.db.CurrentWeatherEntry
import com.samir.weatherlogger.data.db.DailyWeatherEntry
import com.samir.weatherlogger.data.db.HourlyWeatherEntry
import com.samir.weatherlogger.data.db.WeatherLocationEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(): LiveData<CurrentWeatherEntry>

}