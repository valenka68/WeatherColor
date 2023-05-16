package ru.valyabulanova.weathercolor.weather

import com.example.weathercolor.R
import java.io.Serializable
import java.util.*
import java.util.Calendar.*
import kotlin.String as String


data class WeatherModel(
    val tempLike: String,
    val condition: String,
    val currentTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val date: Date,
    var hours: List<HoursModel>
) : Serializable {
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

    @JvmName("getTempLike1")
    fun getTempLike(): String {
        val tLike = "Ощущается как " + tempLike.toFloat().toInt().toString() + "°"
        return tLike
    }

    @JvmName("getMaxMin1")
    fun getMaxMin(): String {
        val t = maxTemp.toFloat().toInt().toString() + "°" + "/" + minTemp.toFloat().toInt().toString() + "°"
        return t
    }

    @JvmName("getCurrentTemp1")
    fun getCurrentTemp(): String {
        val curTemp = currentTemp.toFloat().toInt().toString() + "°"
        return curTemp
    }

    @JvmName("getMaxTemp1")
    fun getMaxTemp(): String {
        val maxT = maxTemp.toFloat().toInt().toString() + "°"
        return maxT
    }

    @JvmName("getMinTemp1")
    fun getMinTemp(): String {
        val minT = minTemp.toFloat().toInt().toString() + "°"
        return minT
    }

    fun getDay(): String {
        val day = date
        val calendar = getInstance()
        calendar.time = day
        val dayOfWeek = calendar.getDisplayName(DAY_OF_WEEK, LONG, Locale("ru"))
        val number = day.date
        val monthForText = calendar.getDisplayName(MONTH, LONG, Locale("ru"))

        val dayOfWeekForText = when (dayOfWeek?.toString()) {
            "понедельник" -> "пн"
            "вторник" -> "вт"
            "среда" -> "ср"
            "четверг" -> "чт"
            "пятница" -> "пт"
            "суббота" -> "сб"
            "воскресенье" -> "вс"
            else -> ""
        }
        return "$number $monthForText, $dayOfWeekForText"
    }
}
