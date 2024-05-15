package com.mike.attendancesystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun StudentProfile(navController: NavController) {
Column(modifier = Modifier
    .background(brush)
    .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier
            .width(350.dp)
            .height(200.dp)
            .background(color = Color(0xffA0E9FF), shape = RoundedCornerShape(20.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly) {
            Image(painter = painterResource(id = R.drawable.teacher), contentDescription = "dp",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp))

            Text(text = "BSCS/108J/2021", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)

        }
        Column(modifier = Modifier
            .height(400.dp)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,) {
            Row(modifier = Modifier

                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                SquareBox(
                    imageName = painterResource(id = R.drawable.timetable),
                    content = "Timetable",
                    navController = navController,
                    route ="timetable")
                SquareBox(
                    imageName = painterResource(id = R.drawable.attendance),
                    content = "Attendance",navController = navController,
                    route ="attendance")

            }
            Row(modifier = Modifier

                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                SquareBox(imageName = painterResource(id = R.drawable.announcement), content = "Announcements",navController = navController, route ="announcements")
                SquareBox(imageName = painterResource(id = R.drawable.resources), content = "Resources",navController = navController, route ="resources")

            }
        }
    }
}
@Composable
fun SquareBox(
    imageName: Painter,
    content: String,
    route: String,
    navController: NavController
) {
    val image: Painter = imageName

    Box(
        modifier = Modifier
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .background(color = Color(0xffA0E9FF))
            .size(150.dp)
            .clickable { navController.navigate(route) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .size(90.dp)
                    .background(color = Color(0xffCDF5FD), shape = CircleShape)
            ) {
                Image(
                    painter = image,
                    contentDescription = "box content",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(90.dp)
                )
            }
            Text(
                text = content,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}




@Preview
@Composable
fun StudentProfilePreview() {
    StudentProfile(rememberNavController())
}