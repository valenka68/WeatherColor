package ru.valyabulanova.weathercolor.usecases.city

import ru.valyabulanova.weathercolor.usecases.common.data.Weather


interface GettingWeatherForecastForCityUseCase {
    suspend operator fun invoke(city: String): List<Weather>
}