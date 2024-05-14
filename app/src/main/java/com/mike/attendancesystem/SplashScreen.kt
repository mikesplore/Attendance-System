package com.mike.attendancesystem

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

val brush = Brush.verticalGradient(
    colors = listOf(
        Color(0xff89CFF3),
        Color(0xffCDF5FD)

    )
)

@Composable
fun SplashScreen(navController: NavController){
    Column(modifier  = Modifier
        .fillMaxSize()
        .background(brush),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .background(Color.Transparent, shape = RoundedCornerShape(20.dp))
            .size(230.dp), contentAlignment = Alignment.Center){
        TypeWriteText(text = "ATTENDANCE SYSTEM")

        }
        Text(text = "Continue >>",
            fontSize = 15.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .clickable {
                    navController.navigate("LoginChoice")

                }

            )

    }
}

@Composable
fun TypeWriteText(
    text: String,
    modifier: Modifier = Modifier,
    isVisible: Boolean = true,
    spec: AnimationSpec<Int> = tween(durationMillis = text.length *100, easing = LinearEasing),
    style: TextStyle = LocalTextStyle.current,
    preoccupySpace: Boolean = true
){
    var textToAnimate by remember { mutableStateOf("") }

   val index = remember {
        Animatable(initialValue = 0, typeConverter = Int.VectorConverter)
    }

    // Effect to handle animation when visibility changes
    LaunchedEffect(isVisible) {
        if (isVisible) {
            textToAnimate = text
            index.animateTo(text.length, spec)
        } else {
            index.snapTo(0)
        }
    }

    LaunchedEffect(text) {
        if (isVisible) {
            // Reset animation and update text if visible
            index.snapTo(0)
            textToAnimate = text
            index.animateTo(text.length, spec)
        }
    }

    Box(modifier = modifier) {
        if (preoccupySpace && index.isRunning) {

            Text(
                text = text,
                style = style,

                modifier = Modifier.alpha(0f)
            )
        }

        Text(
            text = textToAnimate.substring(0, index.value),
            style = style,
            fontSize = 34.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold

        )
    }


}



@Preview
@Composable
fun SplashPreview(){
    SplashScreen(rememberNavController())
}

