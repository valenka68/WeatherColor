package com.example.valentinabulanova.weather.weather.network.retrofit.data

import java.time.LocalDate


data class Forecastday(
    val astro: Astro,
    val date: String,
    val date_epoch: Int,
    val day: Day,
    val hour: List<Hour>
) {
    fun getDay(): String {
        val day = date
        val data = LocalDate.parse(day)
        val month = data.month.toString()
        val dayOfWeek = data.dayOfWeek.toString()
        val number = data.dayOfMonth.toString()
        val monthForText = when (month) {
            "JANUARY" -> "января"
            "FEBRUARY" -> "февраля"
            "MARCH" -> "марта"
            "APRIL" -> "апреля"
            "MAY" -> "мая"
            "JUNE" -> "июня"
            "JULY" -> "июля"
            "AUGUST" -> "августа"
            "SEPTEMBER" -> "сентября"
            "OCTOBER" -> "октября"
            "NOVEMBER" -> "ноября"
            "DECEMBER" -> "декабря"
            else -> ""
        }

        val dayOfWeekForText = when (dayOfWeek) {
            "MONDAY" -> "пн"
            "TUESDAY" -> "вт"
            "WEDNESDAY" -> "ср"
            "THURSDAY" -> "чт"
            "FRIDAY" -> "пт"
            "SATURDAY" -> "сб"
            "SUNDAY" -> "вс"
            else -> ""
        }

        return "$number $monthForText, $dayOfWeekForText"
    }
}