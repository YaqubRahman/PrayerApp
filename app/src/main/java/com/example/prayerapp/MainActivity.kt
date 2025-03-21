package com.example.prayerapp
import android.os.Build
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.cos
import kotlin.math.sin
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.prayerapp.ui.theme.PrayerAppTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {

    fun getData() {
        val client = SalahClient().getApi().build().create(PrayerApiService::class.java)
        client.getSalah().enqueue(object : Callback<PrayerApiResponse> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(
                call: Call<PrayerApiResponse>,
                response: Response<PrayerApiResponse>
            ) {
                val data = response.body()
                data?.let {
                    Log.d(TAG, "fajr: ${data.data.timings.Fajr}")
                    Log.d(TAG, "dhuhr: ${data.data.timings.Dhuhr}")
                    Log.d(TAG, "asr: ${data.data.timings.Asr}")
                    Log.d(TAG, "maghrib: ${data.data.timings.Maghrib}")
                    Log.d(TAG, "isha: ${data.data.timings.Isha}")
                }
            }

            override fun onFailure(call: Call<PrayerApiResponse>, t: Throwable) {
                Log.d(TAG, "FAIL")
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PrayerAppTheme {
                val navItemList = listOf(
                    NavItem("Salah Times", ImageVector.vectorResource(id = R.drawable.homeicon)),
                    NavItem("Notifications", Icons.Default.Notifications),
                    NavItem("Settings", Icons.Default.Settings),
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            navItemList.forEachIndexed {index, navItem ->
                                NavigationBarItem(
                                    selected = true,
                                    onClick = { },
                                    icon = {Icon(imageVector = navItem.icon, contentDescription ="Icon", Modifier.size(24.dp))},
                                    label = {Text(text = navItem.label)}
                                )
                            }

                        }
                    },
                    content = { paddingValues ->
                        MyScreen(paddingValues) // Your screen content
                    }
                )
            }
        }
        getData()
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
    fun MyScreen(paddingValues: PaddingValues) {
        val backgroundColor = Color(16, 17, 17)
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .background(backgroundColor)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(50.dp, 1.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnnotatedCircle(modifier = Modifier.size(400.dp))
            Spacer(modifier = Modifier.size(16.dp))
            MyBox1()
            Spacer(modifier = Modifier.size(16.dp))
            MyBox2()
            Spacer(modifier = Modifier.size(16.dp))
            MyBox3()
            Spacer(modifier = Modifier.size(16.dp))
            MyBox4()
        }
    }

    @Composable
    fun MyBox1() {
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
                    .clip(RoundedCornerShape(30.dp))
            )


            Text(
                text = "Dhur:12:18",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(0.dp, 2.dp)
            )

            Text(
                text = "Dhur:12:18",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = customWhite,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }


    @Composable
    fun MyBox2() {
        val customColor = Color(27, 69, 27, 255)
        val customWhite = Color(255, 122, 125, 255)
        Box(
            modifier = Modifier
                .width(260.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(customColor)
        ) {
            Image(
                painter = painterResource(id = R.drawable.londonasrimage),
                contentDescription = "London Asr Image",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(30.dp))
            )



            Text(
                text = "Asr:14:15",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(0.dp, 2.dp)
            )

            Text(
                text = "Asr:14:15",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = customWhite,
                modifier = Modifier.fillMaxWidth()
            )


        }
    }

    @Composable
    fun MyBox3() {
        val customColor = Color(27, 69, 27, 255)
        val customWhite = Color(255, 122, 125, 255)
        Box(
            modifier = Modifier
                .width(260.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(customColor)
        ) {
            Image(
                painter = painterResource(id = R.drawable.londonmaghribimage),
                contentDescription = "London Maghrib Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(30.dp))
            )



            Text(
                text = "Maghrib:16:43",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(0.dp, 2.dp)
            )

            Text(
                text = "Maghrib:16:43",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = customWhite,
                modifier = Modifier.fillMaxWidth()
            )


        }
    }

    @Composable
    fun MyBox4() {
        val customColor = Color(27, 69, 27, 255)
        val customWhite = Color(255, 122, 125, 255)
        Box(
            modifier = Modifier
                .width(260.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(customColor)
        ) {
            Image(
                painter = painterResource(id = R.drawable.londonishaimage),
                contentDescription = "London Isha Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(30.dp))
            )



            Text(
                text = "Isha:18:20",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(0.dp, 2.dp)
            )

            Text(
                text = "Isha:18:20",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = customWhite,
                modifier = Modifier.fillMaxWidth()
            )


        }
    }
}
