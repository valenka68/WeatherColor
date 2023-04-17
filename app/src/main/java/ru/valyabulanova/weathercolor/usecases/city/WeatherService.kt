package ru.valyabulanova.weathercolor.usecases.city

import ru.valyabulanova.weathercolor.usecases.common.data.Weather


interface WeatherService {
    suspend fun getForecast(city: String): List<Weather>
}