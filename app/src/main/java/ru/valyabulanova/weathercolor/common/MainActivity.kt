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
            weatherItem(WeatherData("+23", R.drawable.sun, "1 марта"))
        }
    }


}

