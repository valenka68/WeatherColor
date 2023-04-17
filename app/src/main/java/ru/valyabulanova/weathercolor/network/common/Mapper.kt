package com.example.valentinabulanova.weather.common.data

import ru.valyabulanova.weathercolor.usecases.common.data.WeatherCondition
import java.lang.Exception

fun initWeatherConditionByCode(code: Int): WeatherCondition {
    return when (code) {
        1000 -> WeatherCondition.Sunny
        1003 -> WeatherCondition.PartlyCloudy
        1006 -> WeatherCondition.Cloudy
        1009 -> WeatherCondition.Overcast
        1030 -> WeatherCondition.Mist
        1063 -> WeatherCondition.PatchyRainPossible
        1066 -> WeatherCondition.PatchySnowPossible
        1069 -> WeatherCondition.PatchySleetPossible
        1072 -> WeatherCondition.PatchyFreezingDrizzlePossible
        1087 -> WeatherCondition.ThunderyOutbreaksPossible
        1114 -> WeatherCondition.BlowingSnow
        1117 -> WeatherCondition.Blizzard
        1135 -> WeatherCondition.Fog
        1147 -> WeatherCondition.FreezingFog
        1150 -> WeatherCondition.PatchyLightDrizzle
        1153 -> WeatherCondition.LightDrizzle
        1168 -> WeatherCondition.FreezingDrizzle
        1171 -> WeatherCondition.HeavyFreezingDrizzle
        1180 -> WeatherCondition.PatchyLightRain
        1183 -> WeatherCondition.LightRain
        1186 -> WeatherCondition.ModerateRainAtTimes
        1189 -> WeatherCondition.ModerateRain
        1192 -> WeatherCondition.HeavyRainAtTimes
        1195 -> WeatherCondition.HeavyRain
        1198 -> WeatherCondition.LightFreezingRain
        1201 -> WeatherCondition.ModerateOrHeavyFreezingRain
        1204 -> WeatherCondition.LightSleet
        1207 -> WeatherCondition.ModerateOrHeavySleet
        1210 -> WeatherCondition.PatchyLightSnow
        1213 -> WeatherCondition.LightSnow
        1216 -> WeatherCondition.PatchyModerateSnow
        1219 -> WeatherCondition.ModerateSnow
        1222 -> WeatherCondition.PatchyHeavySnow
        1225 -> WeatherCondition.HeavySnow
        1237 -> WeatherCondition.IcePellets
        1282 -> WeatherCondition.ModerateOrHeavySnowWithThunder
        1240 -> WeatherCondition.LightRainShower
        1243 -> WeatherCondition.ModerateOrHeavyRainShower
        1246 -> WeatherCondition.TorrentialRainShower
        1249 -> WeatherCondition.LightSleetShowers
        1252 -> WeatherCondition.ModerateOrHeavySleetShowers
        1255 -> WeatherCondition.LightSnowShowers
        1258 -> WeatherCondition.ModerateOrHeavySnowShowers
        1261 -> WeatherCondition.LightShowersOfIcePellets
        1264 -> WeatherCondition.ModerateOrHeavyShowersOfIcePellets
        1273 -> WeatherCondition.PatchyLightRainWithThunder
        1276 -> WeatherCondition.ModerateOrHeavyRainWithThunder
        1279 -> WeatherCondition.PatchyLightSnowWithThunder
        else -> throw Exception("Неизвестный код состояния погоды в WeatherCondition")
    }
}