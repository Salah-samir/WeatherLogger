 package com.samir.weatherlogger.ui.weather.current

import com.samir.weatherlogger.data.provider.SettingsProvider
import com.samir.weatherlogger.data.repository.ForecastRepository
import com.samir.weatherlogger.internal.lazyDeferred
import com.samir.weatherlogger.ui.weather.base.WeatherViewModel


 class CurrentWeatherViewModel(
     private val forecastRepository: ForecastRepository,
     settingsProvider: SettingsProvider
) : WeatherViewModel(forecastRepository, settingsProvider) {

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather()
    }
}
