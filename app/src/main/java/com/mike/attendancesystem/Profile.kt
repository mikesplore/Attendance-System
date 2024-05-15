package com.mike.attendancesystem

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.ExitToApp
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
import androidx.compose.material3.TopAppBarDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Student(navController: NavController) {
    // Define drawer state and coroutine scope
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Modal navigation drawer for the side menu
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                // Content for the side menu
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(270.dp)
                        .background(color = Color(0xffA0E9FF)),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Content of the drawer
                    Column(
                        modifier = Modifier
                            .background(Color(0xff89CFF3), shape = RoundedCornerShape(10.dp))
                            .height(250.dp)
                            .fillMaxWidth()
                    ) {
                        // Back button in the top right corner
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                modifier = Modifier
                                    .clickable {
                                        // Handle back button click to close the drawer
                                        scope.launch {
                                            drawerState.apply {
                                                if (isClosed) open() else close()
                                            }
                                        }
                                    }
                                    .padding(8.dp)
                            )
                        }
                        // Image and name in the middle of the drawer
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                modifier = Modifier.height(200.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.teacher),
                                    contentDescription = "dp",
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .size(70.dp)
                                )
                                Text(
                                    "Michael Odhiambo",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                )
                                Text(
                                    "BSCS/108J/2021",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                )
                            }
                        }
                    }
                    Row (modifier = Modifier
                        .absolutePadding(0.dp, 0.dp, 0.dp, 10.dp)
                        .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                        ){
                        Icon(imageVector = Icons.Outlined.ExitToApp, contentDescription = "Logout")
                        Text(text = "Logout",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            modifier = Modifier.clickable{
                                navController.navigate("StudentLogin")
                            })
                    }
                }
            }
        }
    ) {
        // Scaffold for the main content
        Scaffold(
            topBar = {
                // Top app bar
                TopAppBar(
                    title = { Text(text = "Student Dashboard") },
                    navigationIcon = {
                        // Menu icon to open/close the drawer
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = "Menu",
                                modifier = Modifier.clickable {
                                    // Handle click to open/close the drawer
                                    scope.launch {
                                        drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                }
                            )
                        }
                    },
                    // Set top app bar colors
                    colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xffA0E9FF))
                )
            },
            content = {
                // Main content of the screen
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush), // Assuming brush is defined elsewhere
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(70.dp)) // Height of the top app bar
                    HeaderContent() // Content for the header
                    BoxContent(navController) // Content for the main section
                }
            }
        )
    }
}


@Composable
fun HeaderContent() {
    Box(modifier = Modifier.shadow(
        elevation = 15.dp
    )){
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
}

@Composable
fun BoxContent(navController: NavController) {
        Column (modifier = Modifier

            .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally){


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
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SquareBox(
            imageName = painterResource(id = R.drawable.assignment),
            content = "Assignments",
            route = "Assignments",
            navController = navController
        )
        SquareBox(
            imageName = painterResource(id = R.drawable.discussion),
            content = "Discussion",
            route = "Discussion",
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