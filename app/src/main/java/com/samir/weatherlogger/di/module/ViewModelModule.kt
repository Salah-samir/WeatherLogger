package com.samir.weatherlogger.di.module

import androidx.lifecycle.ViewModelProvider
import com.samir.weatherlogger.ui.weather.current.CurrentWeatherViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun provideCurrentWeatherViewModelFactory(currentWeatherViewModelFactory: CurrentWeatherViewModelFactory): ViewModelProvider.Factory

}