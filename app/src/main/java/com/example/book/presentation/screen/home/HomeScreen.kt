package com.example.book.presentation.screen.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Environment
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: HomeViewModel = hiltViewModel()){

    var isExpanded = remember { mutableStateOf(false) }
    val list = viewModel.bestSeller.observeAsState()
    val isLoading = viewModel.loadingLiveData.observeAsState()




    if(isLoading.value!!){
        Dialog(
            onDismissRequest = {
//                viewModel._loadingLiveData.postValue(false)
                               },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
            )
        ) {
            CircularProgressIndicator()
        }

    }


    Scaffold(
        modifier =
        if(isExpanded.value) Modifier.alpha(0.5f) else Modifier.alpha(1f),
        topBar = {
            HomeTopView(navController = navHostController)
        },

        content = {
            Column(modifier = Modifier.padding(it)) {
                list.value?.let {
                    HomeContentView(navHostController,list.value!!)
                }
            }
        },



        bottomBar = {
            HomeBottomView()
        },

//        contentColor = if(isExpanded.value!!) Color.LightGray else Color.Unspecified,
//        containerColor = if(isExpanded.value!!) Color.LightGray else Color.White,
        floatingActionButton = {
            contentColorFor(backgroundColor = Color.LightGray)
//            floatingButton(onClicked = { isExpanded.value = !isExpanded.value })
            floatingButton(viewModel = viewModel)
        },

        floatingActionButtonPosition = FabPosition.End

    )
}