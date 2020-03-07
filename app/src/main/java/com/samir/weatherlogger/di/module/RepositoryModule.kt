package com.samir.weatherlogger.di.module

import com.samir.weatherlogger.data.repository.ForecastRepository
import com.samir.weatherlogger.data.repository.ForecastRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindAuthRepository(forecastRepositoryImpl: ForecastRepositoryImpl): ForecastRepository

}