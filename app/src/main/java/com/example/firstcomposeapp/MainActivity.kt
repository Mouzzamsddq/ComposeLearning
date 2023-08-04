package com.example.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize()
                    .background(Color.Green),
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(0.5f).background(Color.Red).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround,
                ) {
                    Text(text = "Hello")
                    Text(text = "World")
                    Text(text = "Hello")
                    Text(text = "Hello")
                    Text(text = "Hello")
                }
                Row(
                    modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.Blue),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = "Hello")
                    Text(text = "World")
                    Text(text = "Hello")
                    Text(text = "Hello")
                }
            }
        }
    }
}
