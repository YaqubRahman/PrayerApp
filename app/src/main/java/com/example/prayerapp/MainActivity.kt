package com.example.prayerapp

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
                    myScreen()
                }
            }
        }
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
fun MyBox3(){
    val customColor = Color(111, 76, 181)
    Box(
        modifier = Modifier
            .size(180.dp)
            .background(customColor)
    )
}

@Composable
fun myScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment  = (Alignment.CenterHorizontally)
    ){
        Greeting("Yaqub")
        MyBox1()
        Spacer(modifier = Modifier.size(16.dp))
        MyBox2()
        Spacer(modifier = Modifier.size(16.dp))
        MyBox3()
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrayerAppTheme {
        myScreen()
    }
}