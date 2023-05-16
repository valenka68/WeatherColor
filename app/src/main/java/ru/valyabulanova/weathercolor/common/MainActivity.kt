package ru.valyabulanova.weathercolor.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ru.valyabulanova.weathercolor.ui.WeatherAppTheme
import ru.valyabulanova.weathercolor.weather.WeatherViewModel
import ru.valyabulanova.weathercolor.weather.weatherItem


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cityName = "Tambov"
        viewModel.getWeather(cityName)
        viewModel.liveDayList.observe(lifecycleScope) { weather ->
            setContent {
                WeatherAppTheme {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            weatherItem(
                                state = viewModel.state,
                                weatherData = weather
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                        if (viewModel.state.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center)
                            )
                        } else if (viewModel.state.error?.isNotEmpty() == true) {
                            Text(
                                text = "Error",
                                color = Color.Red,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}

