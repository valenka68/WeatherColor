package ru.valyabulanova.weathercolor.usecases.common.data

import java.util.*

data class Hours(
    val curTemp: Double,
    val weatherCondition: WeatherCondition,
    val hour: Date
)
