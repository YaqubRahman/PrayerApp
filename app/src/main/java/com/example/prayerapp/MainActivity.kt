package com.example.prayerapp
//
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.cos
import kotlin.math.sin
//
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment


import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.prayerapp.ui.theme.PrayerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PrayerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun AnnotatedCircle(
    modifier: Modifier = Modifier,
    annotationAngles: List<Float> = emptyList(),
    circleColor: Color = Color(167, 194, 241),
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
fun MyScreen(){
    val backgroundColor = Color(241, 216, 167)
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
    }
}


@Composable
fun MyBox1(){
    val customColor = Color(68, 89, 63)
    Box(
        modifier = Modifier
            .size(180.dp)
            .background(customColor)
    )
}


@Composable
fun MyBox2(){
    val customColor = Color(34, 119, 153)
    Box(
        modifier = Modifier
            .size(180.dp)
            .background(customColor)
    )
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrayerAppTheme {
        MyScreen()
    }
}