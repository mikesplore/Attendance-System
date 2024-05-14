package com.mike.attendancesystem

import androidx.compose.runtime.Composable
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

    }

}