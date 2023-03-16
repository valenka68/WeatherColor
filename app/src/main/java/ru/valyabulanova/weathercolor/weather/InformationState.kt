package ru.valyabulanova.weathercolor.weather

import ru.valyabulanova.weathercolor.data.WeatherData

data class InformationState(
    val isLoading: Boolean = false,
    val weather: WeatherData? = null,
    val error: String = ""
)
