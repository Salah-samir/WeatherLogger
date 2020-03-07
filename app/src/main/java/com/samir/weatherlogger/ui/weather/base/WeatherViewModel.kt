package com.samir.weatherlogger.ui.weather.base

import androidx.lifecycle.ViewModel
import com.samir.weatherlogger.data.provider.SettingsProvider
import com.samir.weatherlogger.data.provider.UNIT_SYSTEM_DEF
import com.samir.weatherlogger.data.repository.ForecastRepository
import com.samir.weatherlogger.internal.lazyDeferred

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    settingsProvider: SettingsProvider
): ViewModel() {

    private val unitSystem = settingsProvider.getPreferredUnitSystem()
    val isMetricUnit: Boolean
        get() = unitSystem == UNIT_SYSTEM_DEF

//    val weatherLocation by lazyDeferred {
//        forecastRepository.getWeatherLocation()
//    }
}