package com.example.book.presentation.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navHostController: NavHostController, viewModel: SearchViewModel = hiltViewModel()){

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colorScheme.background
    val wordList = viewModel.SearchWord.observeAsState()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = systemBarColor
        )
    }


    Scaffold (
        topBar = {
            SearchResultTopBar(navHostController = navHostController)
        },
        content = {
            Column(modifier = Modifier.padding(it)) {
                if(wordList.value.isNullOrEmpty().not()){
                    SearchContent(navHostController,wordList.value!!)
                }
            }
        }
    )


}


