package com.samir.weatherlogger.di.module

import com.samir.weatherlogger.data.network.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule.BindModule::class])
class NetworkModule {

    @Module
    interface BindModule{
        @Singleton
        @Binds
        fun bindWeatherNetworkDataService(weatherNetworkDataSourceImpl: WeatherNetworkDataSourceImpl): WeatherNetworkDataSource

        @Singleton
        @Binds
        fun bindConnectivityInterceptor(connectivityInterceptorImpl: ConnectivityInterceptorImpl): ConnectivityInterceptor
    }

    @Singleton
    @Provides
    fun bindApiWeatherService(connectivityInterceptor: ConnectivityInterceptorImpl): ApiWeatherService {
        return ApiWeatherService.invoke(connectivityInterceptor)
    }
}