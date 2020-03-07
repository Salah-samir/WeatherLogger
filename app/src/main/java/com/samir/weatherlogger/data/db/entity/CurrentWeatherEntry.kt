package com.samir.weatherlogger.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry (
    var temp: Double,
    var humidity: Int,
    var description: String,
    var main: String,
    var deg: Int,
    var speed: Double

    ){
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}