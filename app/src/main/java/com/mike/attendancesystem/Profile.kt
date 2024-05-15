package com.mike.attendancesystem

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Student(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Student Profile") },
                navigationIcon = {
                    IconButton(onClick = {
                        // Handle navigation icon click
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush), // Assuming brush is defined elsewhere
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(70.dp)) // Height of the top app bar
                HeaderContent()
                BoxContent(navController)
            }
        }
    )
}

@Composable
fun HeaderContent() {
    //this column has been partly covered by the top app bar
    //fix it such that it shows below the top app bar
    Column(
        modifier = Modifier
            .width(350.dp)
            .height(200.dp)
            .background(color = Color(0xffA0E9FF), shape = RoundedCornerShape(20.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.teacher),
            contentDescription = "dp",
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
        )
        Text(
            text = "BSCS/108J/2021",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BoxContent(navController: NavController) {
    Column(
        modifier = Modifier
            .height(400.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SquareBox(
                imageName = painterResource(id = R.drawable.timetable),
                content = "Timetable",
                route = "timetable",
                navController = navController
            )
            SquareBox(
                imageName = painterResource(id = R.drawable.attendance),
                content = "Attendance",
                route = "attendance",
                navController = navController
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SquareBox(
                imageName = painterResource(id = R.drawable.announcement),
                content = "Announcements",
                route = "announcement",
                navController = navController
            )
            SquareBox(
                imageName = painterResource(id = R.drawable.resources),
                content = "Resources",
                route = "resources",
                navController = navController
            )
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
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .background(color = Color(0xffCDF5FD), shape = CircleShape)
            ) {
                Image(
                    painter = imageName,
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
    Student(rememberNavController())
}