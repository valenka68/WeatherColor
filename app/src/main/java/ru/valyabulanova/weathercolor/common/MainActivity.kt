package ru.valyabulanova.weathercolor.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.weathercolor.R
import ru.valyabulanova.weathercolor.data.WeatherData
import ru.valyabulanova.weathercolor.weatherItem

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            weatherItem(
                listOf(
                    WeatherData("+23", R.drawable.rain, "1 марта"),
                    WeatherData("+25", R.drawable.sun, "2 марта"),
                    WeatherData("+26", R.drawable.cloud, "3 марта"),
                    WeatherData("+27", R.drawable.sun, "4 марта"),
                    WeatherData("+28", R.drawable.rain, "5 марта")
                )
            )
        }
    }


}

