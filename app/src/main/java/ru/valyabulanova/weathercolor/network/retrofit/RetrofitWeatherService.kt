package ru.valyabulanova.weathercolor.network.retrofit

import com.example.valentinabulanova.weather.common.data.initWeatherConditionByCode
import ru.valyabulanova.weathercolor.usecases.city.WeatherService
import com.example.valentinabulanova.weather.weather.network.retrofit.data.Forecastday
import com.example.valentinabulanova.weather.weather.network.retrofit.data.Hour
import com.example.valentinabulanova.weather.weather.network.retrofit.data.WeatherResponse
import ru.valyabulanova.weathercolor.usecases.common.data.Hours
import ru.valyabulanova.weathercolor.usecases.common.data.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import javax.inject.Inject


class RetrofitWeatherService @Inject constructor(private val weatherApi: WeatherApi) : WeatherService {
    override suspend fun getForecast(city: String) =
        getWeather(city).toWeatherList()

    private suspend fun getWeather(city: String) = withContext(Dispatchers.IO) {
        weatherApi.getWeatherList(city)
    }


    private fun WeatherResponse.toWeatherList() = forecast.forecastday
        .map { it.toWeather(this) }

    private fun Forecastday.toWeather(
        data: WeatherResponse
    ) = Weather(
        tempLike = data.current.feelslike_c,
        weatherCondition = initWeatherConditionByCode(data.current.condition.code),
        currentTemp = data.current.temp_c,
        maxTemp = day.maxtemp_c,
        minTemp = day.mintemp_c,
        date = SimpleDateFormat("yyyy-MM-dd").parse(date),
        hours = hour.toHoursList()
    )

    private fun List<Hour>.toHoursList() = map { it.toHours() }

    private fun Hour.toHours() = Hours(
        curTemp = temp_c,
        weatherCondition = initWeatherConditionByCode(condition.code),
        hour = SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time)
    )
}