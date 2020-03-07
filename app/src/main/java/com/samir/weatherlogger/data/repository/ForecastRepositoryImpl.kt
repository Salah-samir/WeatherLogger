package com.samir.weatherlogger.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.samir.weatherlogger.data.db.*
import com.samir.weatherlogger.data.network.WeatherNetworkDataSource
import com.samir.weatherlogger.data.network.response.WeatherResponse
import com.samir.weatherlogger.data.provider.LocationProvider
import com.samir.weatherlogger.data.provider.SettingsProvider
import com.samirmetric.weatherlogger.utils.Constant
import kotlinx.coroutines.*
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

const val KEY = "950480add29ae25e708adc1f6e76d433"


class ForecastRepositoryImpl @Inject constructor(
    private val currentWeatherDao: CurrentWeatherDao,
    private val weatherNetworkDataSource: WeatherNetworkDataSource,
    private val settingsProvider: SettingsProvider,
    private val locationProvider: LocationProvider
) : ForecastRepository {
    var currentWeatherEntry:CurrentWeatherEntry ?= null

    init {
        weatherNetworkDataSource.apply {
            downloadedWeather.observeForever { newWeather ->
                presistFetchedWeather(newWeather)
            }
        }
        currentWeatherEntry = CurrentWeatherEntry(0.0,0,"","",0,0.0)
    }

    private suspend fun initWeatherData() {
            fetchWeather()
    }

    private fun presistFetchedWeather(fetchedWeather: WeatherResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            currentWeatherEntry!!.temp= fetchedWeather.main.temp
            currentWeatherEntry!!.humidity= fetchedWeather.main.humidity
//            currentWeatherEntry!!.description= fetchedWeather
            currentWeatherEntry!!.deg= fetchedWeather.wind.deg
            currentWeatherEntry!!.speed= fetchedWeather.wind.speed

            currentWeatherDao.upsert(currentWeatherEntry!!)
        }
    }

    override suspend fun getCurrentWeather(): LiveData<CurrentWeatherEntry> {
        return withContext(Dispatchers.IO) {
            return@withContext currentWeatherDao.getWeather()
        }
    }

    private suspend fun fetchWeather() {
        weatherNetworkDataSource.fetchWeather(
            locationProvider.getPreferredLocationString(), "metric",
            settingsProvider.getPreferredLanguage(),apiKey = KEY
        )
    }

    private fun isUpdateFreq(lastFetchTime: ZonedDateTime): Boolean {
        val updateFrequency = settingsProvider.getPreferredUpdateFrequency().toLong()
        val minutesAgo = ZonedDateTime.now().minusMinutes(updateFrequency) //update frequency
        return lastFetchTime.isBefore(minutesAgo)
    }

}