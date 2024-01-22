package com.example.book.presentation.screen.main

import android.annotation.SuppressLint
import android.util.Log
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
fun MainScreen(navHostController: NavHostController, viewModel: MainViewModel = hiltViewModel()){

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colorScheme.background
    val data = viewModel.dataList.observeAsState()
    val edtFocus = viewModel.EdtFocusLiveData.observeAsState(initial = false)

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = systemBarColor
        )
    }


    Scaffold (
        topBar = {
            MainTopBar(viewModel = viewModel)
        },

        content = {
            Column(modifier = Modifier.padding(it)) {
//                if(data.value.isNullOrEmpty().not()){
                Log.e("MainScreen",edtFocus.value.toString())
                    MainContent(navHostController,data.value,edtFocus.value)
//                }
            }
        }
    )



}