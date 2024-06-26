package com.example.book.presentation.screen.searchResult

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.book.presentation.screen.common.ErrDialog
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchResultScreen(navHostController: NavHostController, searchWord : String?, viewModel: SearchResultViewModel = hiltViewModel()){

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colorScheme.background
    val data = viewModel.dataList.observeAsState()
    val errMsg = viewModel.errMSgLiveData.observeAsState()
//    val edtFocus = viewModel.EdtFocusLiveData.observeAsState(initial = false)
    viewModel.getItemList(searchWord!!)

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = systemBarColor
        )
    }


    Scaffold (
        topBar = {
            SearchResultTopBar(navHostController = navHostController, searchWord = searchWord)
        },

        content = {
            Column (modifier = Modifier.padding(it)){
                if(errMsg.value.isNullOrEmpty().not()){
                    ErrDialog(errMsg.value!!)
                }else{
                    if(data.value.isNullOrEmpty().not()){
                        SearchResultContent(navHostController, data.value)
                    }
                }
            }
        }
    )
}



