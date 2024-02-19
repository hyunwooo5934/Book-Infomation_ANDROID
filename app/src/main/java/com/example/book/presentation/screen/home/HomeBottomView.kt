package com.example.book.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.book.presentation.navigation.Screen
import com.example.book.util.view.commonView.verticalSpacer

@Composable
fun HomeBottomView(navController: NavController) {

    Column(
        modifier = Modifier.wrapContentHeight().background(Color.White)
    ) {

        Spacer(modifier = Modifier
            .fillMaxWidth(1f)
            .height(0.2.dp)
            .background(Color.LightGray))

        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(1f).padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
        ){

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
            ){
                IconButton(onClick = {
                }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "home"
                    )
                }
                Text(text = "홈", textAlign = TextAlign.Center, fontSize = 10.sp)
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
            ){
                IconButton(onClick = {
                }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "search"
                    )
                }
                Text(text = "검색", textAlign = TextAlign.Center, fontSize = 10.sp)
            }


            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
            ){
                IconButton(onClick = {
                }) {
                    Icon(
                        imageVector = Icons.Filled.Face,
                        contentDescription = "face"
                    )
                }
                Text(text = "기타", textAlign = TextAlign.Center, fontSize = 10.sp)
            }


            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
            ){
                IconButton(onClick = {
                }) {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "like"
                    )
                }
                Text(text = "좋아요", textAlign = TextAlign.Center, fontSize = 10.sp)
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
            ){
                IconButton(onClick = {
                }) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "account"
                    )
                }
                Text(text = "내 정보", textAlign = TextAlign.Center, fontSize = 10.sp)
            }
        }

    }



}