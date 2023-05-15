package ru.valyabulanova.weathercolor.weather


import com.example.weathercolor.R
import java.io.Serializable
import java.util.*

data class HoursModel(
    val curTemp: String,
    val condition: String,
    val hour: Date
) : Serializable {
    fun getHour(): String {
        val hour = hour.hours
        return hour.toString() + ":00"
    }
    fun getImage(): Int {
        when (condition) {
            //TODO()
            "PartlyCloudy" -> return R.drawable.cloud
            "Sunny" -> return R.drawable.sun
            "Cloudy" -> return R.drawable.cloud
            "Rainy" -> return R.drawable.rain
            "PatchyLightRainWithThunder" -> return R.drawable.rain
            "PatchyRainPossible" -> return R.drawable.rain
            else -> return R.drawable.sun
        }
    }
    fun getTemp(): String {
        val temp = curTemp.toFloat().toInt().toString() + "°"
        return temp
    }
}
