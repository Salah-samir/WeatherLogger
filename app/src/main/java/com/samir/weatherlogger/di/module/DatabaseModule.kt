package com.samir.weatherlogger.di.module

import android.content.Context
import com.samir.weatherlogger.data.db.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideWeatherDatabase(context: Context): WeatherDatabase = WeatherDatabase.invoke(context)

    @Singleton
    @Provides
    fun provideCurrentWeatherDao(weatherDatabase: WeatherDatabase): CurrentWeatherDao = weatherDatabase.currentWeatherDao()

//    @Singleton
//    @Provides
//    fun provideHourlyWeatherDao(weatherDatabase: WeatherDatabase): HourlyWeatherDao = weatherDatabase.hourlyWeatherDao()
//
//    @Singleton
//    @Provides
//    fun provideDailyWeatherDao(weatherDatabase: WeatherDatabase): DailyWeatherDao = weatherDatabase.dailyWeatherDao()
//
//    @Singleton
//    @Provides
//    fun provideWeatherLocationDao(weatherDatabase: WeatherDatabase): WeatherLocationDao = weatherDatabase.weatherLocationDao()

}