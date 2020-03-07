package com.samir.weatherlogger.di.module

import android.app.Application
import android.content.Context
import com.samir.weatherlogger.data.provider.LocationProvider
import com.samir.weatherlogger.data.provider.LocationProviderImpl
import com.samir.weatherlogger.data.provider.SettingsProvider
import com.samir.weatherlogger.data.provider.SettingsProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
abstract class AppModule {

    @Binds
    abstract fun provideApplicationContext(application: Application?): Context

    @Singleton
    @Binds
    abstract fun provideSettingsProvider(settingsProviderImp: SettingsProviderImpl): SettingsProvider

    @Singleton
    @Binds
    abstract fun provideLocationProvider(locationProviderImpl: LocationProviderImpl): LocationProvider

}
