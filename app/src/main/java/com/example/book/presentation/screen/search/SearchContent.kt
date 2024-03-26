package com.example.book.presentation.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.book.R
import com.example.domain.model.SearchWord

@Composable
fun SearchContent(navHostController: NavHostController, dataList : List<SearchWord>){
    SearchList(navHostController,dataList)
}

@Composable
fun SearchList(
    navHostController: NavHostController,
    dataList : List<SearchWord>
){
    Column (
        modifier = Modifier
            .background(colorResource(id = R.color.white))
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {

        Text(text = "최근 검색어", fontWeight = FontWeight.Bold)

        var listState = rememberLazyListState()
        LazyColumn(state =  listState){
            dataList?.let {
                itemsIndexed(dataList!!){ index, item ->
                    SearchItem(navController = navHostController, item = item)
                }
            }
        }
    }
}