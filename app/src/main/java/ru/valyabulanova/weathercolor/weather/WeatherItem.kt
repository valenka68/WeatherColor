package ru.valyabulanova.weathercolor

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercolor.R
import ru.valyabulanova.weathercolor.data.WeatherData
import ru.valyabulanova.weathercolor.ui.theme.*

@Composable
fun weatherItem(weatherData: List<WeatherData>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Background,
                        LightBlue,
                        MoreLightBlue
                    ),
                ),
            )
            .padding(top = 20.dp)
    ) {
        Text(
            text = "Тамбов",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 26.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Light,
            color = TextColor2
        )
        Card(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(300.dp)
                .padding(20.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                CardColor2,
                                CardColor3,
                                CardColor1
                            )
                        )
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
                    text = weatherData[0].date,
                    fontSize = 23.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Light,
                    color = TextColor
                )
                Image(
                    painter = painterResource(id = weatherData[0].image),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                )
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = weatherData[0].temp,
                    fontSize = 45.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = TextColor
                )
                Text(
                    text = "Облачно",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Light,
                    color = TextColor
                )

            } // end of Column
        } // end of Card
        Row(
            modifier = Modifier.padding(10.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            setUpCards(weatherData)// end of Card
        } // end of Raw
    } // end of main column
}

@Composable
private fun setUpCards(weatherData: List<WeatherData>) {
    for (index in weatherData.indices) {
        Card(
            modifier = Modifier.padding(end = 5.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = 5.dp
        ) {
            Column(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                BoxColor1,
                                BoxColor2,
                                BoxColor3
                            )
                        )
                    )
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = weatherData[index].date,
                    fontSize = 13.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Light,
                    color = TextColor
                )
                Image(
                    painter = painterResource(id = weatherData[index].image),
                    contentDescription = "image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(50.dp)
                )
                Text(
                    text = weatherData[index].temp,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = TextColor
                )
                Text(
                    text = "Облачно",
                    fontSize = 11.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Light,
                    color = TextColor
                )

            } // end of Column
        }
    }

}