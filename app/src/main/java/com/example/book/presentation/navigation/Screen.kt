package com.example.book.presentation.navigation

sealed class Screen(val route : String) {
    object Home : Screen("home_screen")
    object Search : Screen("search_screen")
    object SearchResult : Screen("search_result_screen")
    object Detail : Screen("detail_screen")
    object SearchWord : Screen("search_history_screen")

    object WebPage : Screen("web_screen")
}
