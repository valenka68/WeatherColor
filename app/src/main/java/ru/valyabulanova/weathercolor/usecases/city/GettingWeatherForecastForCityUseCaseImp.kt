package ru.valyabulanova.weathercolor.usecases.city


class GettingWeatherForecastForCityUseCaseImp(private val weatherService: WeatherService) :
    GettingWeatherForecastForCityUseCase {
    override suspend operator fun invoke(city: String) = weatherService.getForecast(city)
}