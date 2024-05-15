package com.mike.attendancesystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun  NavGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = "Intro" ) {
        composable("Intro"){SplashScreen(navController)}
        composable("LoginChoice"){ MainLogin(navController = navController)}
        composable("TeacherLogin"){TeacherLogin(navController = navController)}
        composable("StudentLogin"){StudentLogin(navController = navController)}
        composable("TeacherRegister"){ TeacherRegister(navController = navController)}
        composable("StudentRegister"){ StudentRegister(navController = navController)}
        composable("announcement"){ Announcements(navController = navController)}
        composable("attendance"){Attendance(navController = navController)}
        composable("resources"){Resources(navController = navController)}
        composable("timetable"){Timetable(navController = navController)}
        composable("StudentDashboard"){StudentDashboard(navController = navController)}



    }

}

val StudentBrush = Brush.verticalGradient(
    colors = listOf(
        Color(0xff89CFF3),
        Color(0xffCDF5FD)

    )
)

val TeacherBrush = Brush.verticalGradient(
    colors = listOf(
        Color(0xffFF7ED4),
        Color(0xffFFB5DA)
    )
)