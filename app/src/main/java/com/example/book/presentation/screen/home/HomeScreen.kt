package com.example.book.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import okhttp3.internal.wait

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: HomeViewModel = hiltViewModel()){

    var isExpanded = remember { mutableStateOf(false) }

    Scaffold(
        modifier =
        if(isExpanded.value!!) Modifier.alpha(0.5f) else Modifier.alpha(1f),
        topBar = {
            HomeTopView(navController = navHostController)
        },

        content = {
            Column(modifier = Modifier.padding(it)) {
                HomeContentView()
            }
        },

        bottomBar = {
            HomeBottomView(navController = navHostController)
        },

//        contentColor = if(isExpanded.value!!) Color.LightGray else Color.Unspecified,
//        containerColor = if(isExpanded.value!!) Color.LightGray else Color.White,
        floatingActionButton = {
            contentColorFor(backgroundColor = Color.LightGray)
            floatingButton(onClicked = { isExpanded.value = !isExpanded.value })
        },


    )

}