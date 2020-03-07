package com.samir.weatherlogger.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.samir.weatherlogger.data.provider.SettingsProvider
import com.samir.weatherlogger.data.repository.ForecastRepository
import javax.inject.Inject

class CurrentWeatherViewModelFactory @Inject constructor(
    private val forecastRepository: ForecastRepository,
    private val settingsProvider: SettingsProvider
) : ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastRepository, settingsProvider) as T
    }
}