package com.samir.weatherlogger

import android.content.Context
import com.jakewharton.threetenabp.AndroidThreeTen
import com.samir.weatherlogger.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class WeatherLoggerApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        AndroidThreeTen.init(this)
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

    companion object {

        lateinit  var appContext: Context

    }

    fun getContext(): Context {
        return appContext
    }
}