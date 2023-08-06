package com.example.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize()
                    .background(Color.Green)
                    /**
                     * diff b/w width and required width attribute
                     * If we are passing width less than maximum parent width, it will use the given width. If we are passing width exceeding the parent maximum width,
                     * then it will consider the parent maximum width.
                     * But in case of requiredWidth attribute, it will always consider the given width whether it exceeds with the parent maximum width. it does not care.
                     */
                    .width(300.dp),
//                    .requiredWidth(600.dp),
            ) {
                Column(
                    /**
                     * In the jetpack compose, modifier execute sequentially, so we can call same method one after another, it will lead
                     * to the different result.
                     */
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .background(Color.Red)
                        .fillMaxWidth()
                        .border(width = 5.dp, color = Color.Black)
                        .padding(20.dp)
                        .border(width = 5.dp, color = Color.Blue)
                        .padding(20.dp),
                ) {
                    Text(
                        text = "Hello",
                        /**
                         * With the help of modifier we can make it intractable also
                         */
                        modifier = Modifier.clickable {
                        },
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(text = "World")
                    Text(text = "Hello")
                    Text(text = "Hello")
                    Text(text = "Hello")
                }
                Column(
                    modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White),
                ) {
                    Text(
                        text = "Hello Mouzzam Nice Project",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Justify,
                        fontStyle = FontStyle.Italic,
                        letterSpacing = 1.sp,
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_broken_heart),
                        contentDescription = "Dummy Image",
                        alignment = Alignment.CenterEnd,
                        modifier = Modifier.height(300.dp).width(300.dp),
                        colorFilter = ColorFilter.tint(Color.Blue),
                        contentScale = ContentScale.FillHeight

                    )
                }
            }
        }
    }
}
