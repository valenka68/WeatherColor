package ru.valyabulanova.weathercolor.weather


data class WeatherState(
    val weatherInfo: List<WeatherModel>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
