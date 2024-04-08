package com.example.book.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import com.example.book.util.view.commonView.WebViewPage
import com.example.domain.model.bestSellerModel
import java.net.URLEncoder

@Composable
fun HomeContentView(
    navHostController: NavHostController,
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
            IconButton(onClick = {
                val link = URLEncoder.encode("https://www.bookprice.co.kr/best.jsp", Charsets.UTF_8.toString())
                navHostController.navigate("detail_screen/$link")
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "search"
                )
            }
        }

        LazyRow {
            itemsIndexed(lits){ _, item ->
                // itemview에 매핑
                HomeRecommandItem(item)
            }
        }
    }
}