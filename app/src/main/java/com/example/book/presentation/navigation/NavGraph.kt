package com.example.book.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.book.presentation.screen.detail.DetailScreen
import com.example.book.presentation.screen.main.MainScreen

@Composable
fun NavGraph(navHostController : NavHostController){
    NavHost(navController = navHostController,
        startDestination = Screen.Home.route){

        composable(route = Screen.Home.route){
            MainScreen(navHostController = navHostController)
        }

        composable(route = Screen.Detail.route){
            DetailScreen()
        }

    }
}