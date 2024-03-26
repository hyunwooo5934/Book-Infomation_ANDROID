package com.example.book.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.domain.model.bestSellerModel

@Composable
fun HomeContentView(
    lits : List<bestSellerModel>
){
    val scrollState = rememberScrollState()


    Column (
        modifier = Modifier.fillMaxSize().verticalScroll(scrollState).background(Color.White)
    ){

        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(start = 10.dp)
        ){
            Text(text = "추천 Book")
            IconButton(onClick = { /* TODO */ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "search"
                )
            }
        }

        LazyRow {
            itemsIndexed(lits){ index, item ->
                // itemview에 매핑
                HomeRecommandItem(item)
            }
        }
    }



}