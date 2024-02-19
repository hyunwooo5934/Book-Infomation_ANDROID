package com.example.book.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.book.presentation.screen.detail.DetailScreen
import com.example.book.presentation.screen.home.HomeScreen
import com.example.book.presentation.screen.searchResult.SearchResultScreen
import com.example.book.presentation.screen.search.SearchScreen

@Composable
fun NavGraph(navHostController : NavHostController){
    NavHost(navController = navHostController,
        startDestination = Screen.Home.route){

        composable(route = Screen.Home.route){
            HomeScreen(navHostController = navHostController)
        }

        composable(route = Screen.Search.route){
            SearchScreen(navHostController = navHostController)
        }

        composable("search_screen/{word}", arguments = listOf(navArgument(name = "word"){
            type = NavType.StringType})){
                backStackEntry -> SearchScreen(navHostController = navHostController, searchWord = backStackEntry.arguments?.getString("word"))
        }

        composable("search_result_screen/{word}", arguments = listOf(navArgument(name = "word"){
            type = NavType.StringType})){
            backStackEntry -> SearchResultScreen(navHostController = navHostController, searchWord = backStackEntry.arguments?.getString("word"))
        }

        composable("detail_screen/{link}", arguments = listOf(navArgument(name = "link"){
        type = NavType.StringType})){
            backStackEntry -> DetailScreen(navHostController = navHostController, webUrl = backStackEntry.arguments?.getString("link"))
        }


    }
}
