package ru.valyabulanova.weathercolor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercolor.R
import ru.valyabulanova.weathercolor.ui.theme.Background
import ru.valyabulanova.weathercolor.ui.theme.TextColor

@Composable
fun weatherItem(weatherData: WeatherData) {
    val klee_one = FontFamily(
        Font(R.font.morice_bejar, FontWeight.Normal),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
            .padding(20.dp)
    ) {
            Text(text = "Тамбов", modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 26.sp, fontFamily = klee_one, fontWeight = FontWeight.Bold, color = Color.White)
            Card(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(200.dp)
                    .padding(10.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = 5.dp,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = weatherData.image),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 10.dp)
                            .clip(CircleShape),
                    )
                    Text(modifier = Modifier.padding(top = 15.dp), text = weatherData.temp, fontSize = 28.sp, fontFamily = klee_one, color = TextColor)
                    Text(modifier = Modifier.padding(top = 10.dp), text = weatherData.date, fontFamily = klee_one, color = TextColor)
            } // end of Column
        } // end of Card
    } // end of main column
}