package ru.valyabulanova.weathercolor.weather

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ru.valyabulanova.weathercolor.usecases.city.GettingWeatherForecastForCityUseCase
import ru.valyabulanova.weathercolor.usecases.common.data.Hours
import ru.valyabulanova.weathercolor.usecases.common.data.Weather
import com.example.weathercolor.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.valyabulanova.weathercolor.common.MutableSingleEventFlow
import java.net.UnknownHostException
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getForecastForCity: GettingWeatherForecastForCityUseCase
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    private val _city = MutableStateFlow("")
    val city: StateFlow<String> get() = _city.asStateFlow()

    private val _dayToday = MutableStateFlow("")
    val dayToday: StateFlow<String> get() = _dayToday.asStateFlow()

    private val _imageResource = MutableStateFlow(0)
    val imageResource: StateFlow<Int> get() = _imageResource.asStateFlow()

    private val _currentTemp = MutableStateFlow("")
    val currentTemp: StateFlow<String> get() = _currentTemp.asStateFlow()

    private val _textForCondition = MutableStateFlow("")
    val textForCondition: StateFlow<String> get() = _textForCondition.asStateFlow()

    private val _liveDayList = MutableStateFlow<List<WeatherModel>>(emptyList())
    val liveDayList: StateFlow<List<WeatherModel>> get() = _liveDayList.asStateFlow()


        fun getWeather(city: String) = viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            try {
                _city.value =
                    city.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                val forecastForCity = getForecastForCity(city)
                val forecastAsModelList = forecastForCity.toWeatherModelList()
                setupWeather(forecastAsModelList)
                state = state.copy(
                    weatherInfo = forecastAsModelList,
                    isLoading = false,
                    error = null
                )
            } catch (error: CancellationException) {
                throw error
                onError()
            } catch (error: Error) {
                onError()
            }  catch (e: UnknownHostException) {
                onError()
            } catch (error: Exception) {
                Log.e("ViewModel",error.message.toString())
                onError()
            }
        }


    private fun List<Weather>.toWeatherModelList() = map { it.toWeatherModel() }

    private fun Weather.toWeatherModel() = WeatherModel(
        tempLike = this.tempLike.toString(),
        condition = this.weatherCondition.name,
        currentTemp = this.currentTemp.toString(),
        maxTemp = this.maxTemp.toString(),
        minTemp = this.minTemp.toString(),
        date = this.date,
        hours = this.hours.toHoursModelList()
    )

    private fun List<Hours>.toHoursModelList() = map { it.toHoursModel() }

    private fun Hours.toHoursModel() = HoursModel(
        curTemp = this.curTemp.toString(),
        condition = this.weatherCondition.name,
        hour = this.hour
    )

    private fun setupWeather(it: List<WeatherModel>) {
        _liveDayList.value = it
        _dayToday.value =
            "Сегодня, ${it[0].getDay()}"
        _currentTemp.value = it[0].getCurrentTemp()
        _textForCondition.value =
            "Ощущается как ${it[0].getTempLike()}"
        _imageResource.value = it[0].getImage()
    }

    private fun onError() {
        Log.e("WeatherViewModel", "Ошибка при получении погоды.")
        state = state.copy(
            weatherInfo = null,
            isLoading = false,
            error = "Ошибка при получении погоды."
        )
    }


}