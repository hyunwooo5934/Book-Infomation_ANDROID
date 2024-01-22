package com.example.book.presentation.screen.main

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.book.R
import com.example.domain.model.bookModel

@Composable
fun MainContent(navHostController: NavHostController, dataList : List<bookModel>?, focusable : Boolean){
    if(focusable){
        Log.e("MainContent","$focusable, SearchList")
        SearchList(focusable)
    } else {
        Log.e("MainContent","$focusable, MainList")
        MainList(navController = navHostController, dataList = dataList)
    }
}

@Composable
fun MainList(
    navController: NavController,
    dataList : List<bookModel>?) {
    Column (
        modifier = Modifier.background(colorResource(id = R.color.white)
        )
    ) {
        var listState = rememberLazyListState()
        LazyColumn(state =  listState){
            dataList?.let {
                itemsIndexed(dataList!!){ index, item ->
                    // item compose 연결
                    Mainitem(navController = navController, item = item)
                }
            }
        }
    }
}

@Composable
fun SearchList(focusable : Boolean){
    if(focusable) {
        Column {
            Text(text = "검색어1")
            Text(text = "검색어2")
            Text(text = "검색어3")
            Text(text = "검색어4")
            Text(text = "검색어5")
        }
    }
}



