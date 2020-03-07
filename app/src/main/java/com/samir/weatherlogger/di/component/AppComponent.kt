package com.samir.weatherlogger.di.component
import android.app.Application
import com.samir.weatherlogger.WeatherLoggerApplication
import com.samir.weatherlogger.di.builder.ActivityBuilder
import com.samir.weatherlogger.di.builder.FragmentBuilder
import com.samir.weatherlogger.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf (AndroidInjectionModule::class, ActivityBuilder::class, FragmentBuilder::class ,
    AppModule::class, DatabaseModule::class,
    NetworkModule::class, RepositoryModule::class, LocationModule::class, ViewModelModule::class))
interface AppComponent : AndroidInjector<WeatherLoggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}