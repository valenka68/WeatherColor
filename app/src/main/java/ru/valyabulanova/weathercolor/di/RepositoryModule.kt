package ru.valyabulanova.weathercolor.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Retrofit
import ru.valyabulanova.weathercolor.network.retrofit.RetrofitWeatherService
import ru.valyabulanova.weathercolor.network.retrofit.WeatherApi
import ru.valyabulanova.weathercolor.usecases.city.GettingWeatherForecastForCityUseCase
import ru.valyabulanova.weathercolor.usecases.city.GettingWeatherForecastForCityUseCaseImp
import ru.valyabulanova.weathercolor.usecases.city.WeatherService

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideCityUseCase(weatherService: WeatherService): GettingWeatherForecastForCityUseCase {
        return GettingWeatherForecastForCityUseCaseImp(weatherService)
    }

    @Provides
    fun provideRetrofitClass(weatherApi: WeatherApi): WeatherService {
        return RetrofitWeatherService(weatherApi)
    }

    @Provides
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}