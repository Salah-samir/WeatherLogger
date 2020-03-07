package com.samir.weatherlogger.di.builder

import com.samir.weatherlogger.ui.weather.current.CurrentWeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun bindCurrentWeatherFragment(): CurrentWeatherFragment
//
//    @ContributesAndroidInjector
//    abstract fun bindTodayWeatherFragment(): TodayWeatherFragment
//
//    @ContributesAndroidInjector
//    abstract fun bindWeekWeatherFragment(): WeekWeatherFragment


}