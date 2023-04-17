package ru.valyabulanova.weathercolor.network.retrofit


import com.example.valentinabulanova.weather.weather.network.retrofit.data.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json?key=16b6f8ba006249fdb76165154223005&days=5&aqi=no&alerts=no")
    suspend fun getWeatherList(@Query("q") query: String): WeatherResponse
}