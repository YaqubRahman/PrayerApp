package com.example.prayerapp
//
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.cos
import kotlin.math.sin
//
//
import androidx.activity.viewModels
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.sp
//
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment


import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.prayerapp.ui.theme.PrayerAppTheme


class MainActivity : ComponentActivity() {

    private val prayerViewModel: PrayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrayerAppTheme {
                val prayerTimes = prayerViewModel.prayerTimes.collectAsState()

                // Display the UI with the fetched prayer times
                MyScreen(prayerTimes.value)
            }
        }
    }
}

@Composable
fun AnnotatedCircle(
    modifier: Modifier = Modifier,
    annotationAngles: List<Float> = emptyList(),
    circleColor: Color = Color(85, 175, 85, 255),
    dotColor: Color = Color.Blue
) {
    Canvas(modifier = modifier) {
        // Get canvas dimensions
        val centerX = size.width / 2f
        val centerY = size.height / 2f
        val radius = minOf(centerX, centerY)

        // Draw the circle
        drawCircle(
            color = circleColor,
            center = Offset(centerX, centerY),
            radius = radius,
            style = Stroke(width = 55f)
        )

        // Draw the annotation dots
        annotationAngles.forEach { angle ->
            val x = centerX + radius * cos(Math.toRadians(angle.toDouble())).toFloat()
            val y = centerY + radius * sin(Math.toRadians(angle.toDouble())).toFloat()

            drawCircle(
                color = dotColor,
                radius = 10f,
                center = Offset(x, y)
            )
        }
    }
}


@Composable
fun MyScreen(prayerTimes: PrayerApiResponse?){
    val backgroundColor = Color(16, 17, 17 )
    Column(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxSize()
            .padding(50.dp, 1.dp),
        horizontalAlignment  = (Alignment.CenterHorizontally)
    ){
        AnnotatedCircle( modifier = Modifier.size(400.dp))
        Spacer(modifier = Modifier.size(16.dp))
        MyBox1()
        Spacer(modifier = Modifier.size(16.dp))
        MyBox2()
        if (prayerTimes != null) {
            // Display prayer times
            Text(text = "Fajr: ${prayerTimes.data.timings.Fajr}", fontSize = 20.sp)
            Text(text = "Dhuhr: ${prayerTimes.data.timings.Dhuhr}", fontSize = 20.sp)
            Text(text = "Asr: ${prayerTimes.data.timings.Asr}", fontSize = 20.sp)
            Text(text = "Maghrib: ${prayerTimes.data.timings.Maghrib}", fontSize = 20.sp)
            Text(text = "Isha: ${prayerTimes.data.timings.Isha}", fontSize = 20.sp)
        } else {
            // Display loading/error message
            Text(text = "Loading prayer times...", fontSize = 20.sp, color = Color.White)
        }
    }
}

@Composable
fun LondonImage(){}


@Composable
fun MyBox1(){
    val customColor = Color(252, 187, 90, 255)
    val customWhite = Color(255, 122, 125, 255)
    Box(
        modifier = Modifier
            .width(260.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(30.dp))


    ) {
        Image(
            painter = painterResource(id = R.drawable.londonimage),
            contentDescription = "London Dhur Image",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(30.dp)))


        Text(text = "Dhur:12:18",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp,2.dp)
        )

        Text(text = "Dhur:12:18",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = customWhite,
            modifier = Modifier.fillMaxWidth())
    }
}


@Composable
fun MyBox2(){
    val customColor = Color(27, 69, 27, 255)
    val customWhite = Color(255, 122, 125, 255)
    Box(
        modifier = Modifier
            .width(260.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(customColor)
    ){
        Image(
            painter = painterResource(id = R.drawable.londonasrimage),
            contentDescription = "London Asr Image",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(30.dp)))



        Text(text = "Asr:14:15",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp,2.dp)
        )

        Text(text = "Asr:14:15",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = customWhite,
            modifier = Modifier.fillMaxWidth())



    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 44.sp

    )
}
