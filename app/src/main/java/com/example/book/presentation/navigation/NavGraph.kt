package com.example.book.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.book.presentation.screen.detail.DetailScreen
import com.example.book.presentation.screen.main.MainScreen

@Composable
fun NavGraph(navHostController : NavHostController){
    NavHost(navController = navHostController,
        startDestination = Screen.Home.route){

        composable(route = Screen.Home.route){
            MainScreen(navHostController = navHostController)
        }

        composable("detail_screen/{link}", arguments = listOf(navArgument(name = "link"){
        type = NavType.StringType})){
            backStackEntry -> DetailScreen(navHostController = navHostController, webUrl = backStackEntry.arguments?.getString("link"))
        }

//        composable(route = Screen.Detail.route){
//            DetailScreen(navHostController = navHostController)
//        }

    }
}