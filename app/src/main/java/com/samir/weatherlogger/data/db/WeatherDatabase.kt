package com.samir.weatherlogger.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.samir.weatherlogger.utils.LocalDateConverter

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocalDateConverter::class)
abstract class WeatherDatabase : RoomDatabase(){
    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object{
        @Volatile private var instance : WeatherDatabase? = null
        private var Lock = Any()

        operator fun invoke(context: Context) = instance?: synchronized(Lock){
            instance?: buildDatabase(context).also{ instance = it }
        }
        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
                WeatherDatabase::class.java, "weather_db")
                .build()
    }
}