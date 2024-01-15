package com.example.book.presentation.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.example.book.R
import com.example.domain.model.bookModel

@Composable
fun MainContent(navHostController: NavHostController, dataList : List<bookModel>){
    MainList(dataList)
}

@Composable
fun MainList(dataList : List<bookModel>){
    Column (
        modifier = Modifier.background(
            colorResource(id = R.color.white)
        )
    ) {
        var listState = rememberLazyListState()
        LazyColumn(state =  listState){
            dataList?.let {
                itemsIndexed(dataList!!){ index, item ->
                    // item compose 연결
                    Mainitem(item)
                }
            }
        }

    }
}