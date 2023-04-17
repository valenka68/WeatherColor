package ru.valyabulanova.weathercolor.usecases.common.data

import java.util.*

data class Weather(
    val tempLike: Double,
    val weatherCondition: WeatherCondition,
    val currentTemp: Double,
    val maxTemp: Double,
    val minTemp: Double,
    val date: Date,
    var hours: List<Hours>
)

