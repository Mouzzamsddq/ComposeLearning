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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
                modifier = Modifier
                    .fillMaxSize()
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
                /**
                 * Like in our view system, we have a different layout , In the same way, to layout our composable, in jetpack compose we
                 * have different layout composable. Column is one of the layout composable. It is used to arrange the composable in vertical manner.
                 * basically row and column composable mimic the linear layout in the view system.
                 */
                Column(
                    /**
                     * In the jetpack compose, modifier execute sequentially, so we can call same method one after another, it will lead
                     * to the different result.
                     */
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .background(Color.White)
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
                    /**
                     * In this box composable layout, we can arrange the composable like a stack , one on the top of another. It mimic the behaviour
                     *  of the frameLayout in the view system
                     */
//                    Box(
//                        contentAlignment = Alignment.BottomEnd,
//                        modifier = Modifier.fillMaxSize(),
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.ic_broken_heart),
//                            contentDescription = "Image 1",
//                        )
//                        Image(
//                            painter = painterResource(id = R.drawable.ic_headphone),
//                            contentDescription = "Image 2",
//                        )
//                    }

                    listViewItem(
                        imageId = R.drawable.ic_person,
                        name = "Mouzzam Siddiqui",
                        occupation = "Software Developer",
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(Color.White),
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
//                        modifier = Modifier.height(300.dp).width(300.dp),
                        colorFilter = ColorFilter.tint(Color.Blue),
                        contentScale = ContentScale.FillHeight,
                    )
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            containerColor = Color.Green,
                        ),
                        enabled = false,
                    ) {
                        Text(text = "Hello")
                        Image(
                            painter = painterResource(id = R.drawable.ic_broken_heart),
                            contentDescription = "Dummy",
                            colorFilter = ColorFilter.tint(Color.Red),
                        )
                    }
                    inputText()
                    /**
                     * Row is also one of the composable layout which mimic the linear layout in view system. It is used to arrange the composable
                     * horizontally.
                     */
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Text(text = "Row 1 ")
                        Text(text = "Row 2 ")
                    }
                }
            }
        }
    }

    /**
     * In compose every thing is related to data, we don't need to update the ui again and again. we only need to
     * update the data. In compose we are calling data as state. because if we are updating the data, the ui will change
     * the state. so every thing we are storing in a state and when we want to perform some action, we only need to
     * update the state. it will automatically recompose the ui.
     */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun inputText() {
        val state = remember {
            mutableStateOf("")
        }
        TextField(
            value = state.value,
            onValueChange = {
                state.value = it
            },
            label = {
                Text(text = "Enter message")
            },
        )
    }

    @Composable
    fun listViewItem(imageId: Int, name: String, occupation: String) {
        Row {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "",
            )
            Column {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = occupation,
                    fontWeight = FontWeight.Thin,
                    fontSize = 12.sp,
                )
            }
        }
    }
}
