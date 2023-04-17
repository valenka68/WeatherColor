package com.example.valentinabulanova.weather.weather.network.retrofit.data

data class WeatherResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)