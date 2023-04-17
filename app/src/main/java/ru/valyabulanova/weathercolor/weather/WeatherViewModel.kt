package ru.valyabulanova.weathercolor.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ru.valyabulanova.weathercolor.usecases.city.GettingWeatherForecastForCityUseCase
import ru.valyabulanova.weathercolor.usecases.common.data.Hours
import ru.valyabulanova.weathercolor.usecases.common.data.Weather
import com.example.weathercolor.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.valyabulanova.weathercolor.common.MutableSingleEventFlow
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getForecastForCity: GettingWeatherForecastForCityUseCase
) : ViewModel() {
    private val _city = MutableStateFlow("")
    val city: StateFlow<String> get() = _city.asStateFlow()

    private val _cardVisibility = MutableStateFlow(false)
    val cardVisibility: StateFlow<Boolean> get() = _cardVisibility.asStateFlow()

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

    private val _message = MutableSingleEventFlow<Int>()
    val message = _message.asSharedFlow()

    fun getWeather(city: String) = viewModelScope.launch(Dispatchers.Default) {
        try {
            _city.value = city.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            val forecastForCity = getForecastForCity(city)
            val forecastAsModelList = forecastForCity.toWeatherModelList()
            setupWeather(forecastAsModelList)
        } catch (error: Throwable) {
            onError(error)
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
        _cardVisibility.value = true
    }

    private fun onError(exception: Throwable) {
        Log.e("WeatherViewModel", "Ошибка при получении погоды.", exception)
        _message.tryEmit(R.string.error)
    }




}