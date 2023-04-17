package ru.valyabulanova.weathercolor.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.weathercolor.R
import dagger.hilt.android.AndroidEntryPoint
import ru.valyabulanova.weathercolor.data.WeatherData
import ru.valyabulanova.weathercolor.weather.HoursModel
import ru.valyabulanova.weathercolor.weather.WeatherModel
import ru.valyabulanova.weathercolor.weather.WeatherViewModel
import ru.valyabulanova.weathercolor.weather.weatherItem
import java.text.SimpleDateFormat


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            val cityName = "Tambov"
            viewModel.getWeather(cityName)
            viewModel.liveDayList.observe(lifecycleScope) { weather ->
                if (weather.isNotEmpty()) {
                    setContent {
                        weatherItem(
                            weather
                        )
                    }
                }
            }

    }


}

