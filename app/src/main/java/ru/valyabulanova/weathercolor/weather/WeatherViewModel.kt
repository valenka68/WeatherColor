package ru.valyabulanova.weathercolor.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {
    var state: LiveData<InformationState> = TODO()
}