package com.example.book.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.book.R
import com.example.book.presentation.navigation.Screen
import com.example.book.util.view.commonView.verticalSpacer


@Composable
fun HomeTopView(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {

    Row(
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp).background(Color.White)
    ) {

        val showDaiog = remember { mutableStateOf(false) }


        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(CornerSize(30.dp)))
                .background(Color.LightGray)
                .fillMaxWidth(0.7f)
                .clickable { navController.navigate(Screen.Search.route) }
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(1f)
            ) {
                IconButton(onClick = {
                    navController.navigate(Screen.Search.route)
                    viewModel.getBestSellerList()
                }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "search"
                    )
                }

                Text(text = stringResource(id = R.string.main_text))
//                Text(text = "1")

                IconButton(onClick = { /* TODO */ }) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "mike"
                    )
                }
            }
        }


        IconButton(onClick = {
            viewModel.readValue()
        }) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "dummy1"
            )
        }
//
        IconButton(onClick = {
//            showDaiog.value = true
            viewModel.writeValue("test11")
        }) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "dummy2"
            )
        }


        /**
         * dialog
         */
        if (showDaiog.value) {
            Dialog(
                onDismissRequest = { /*TODO*/ },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {

                Surface(
                    modifier = Modifier
                        .width(300.dp)
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(CornerSize(10.dp)),
                    color = Color.White
                ) {
                    Column {
                        verticalSpacer(heightSize = 12)

                        Text(
                            text = "test message",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize()
                                .padding(vertical = 8.dp),
                            fontSize = 16.sp
                        )

                        verticalSpacer(heightSize = 12)

                        Button(
                            onClick = { showDaiog.value = false },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp), shape = RoundedCornerShape(24.dp)
                        ) {
                            Text(text = "OK", fontSize = 16.sp)
                        }

                        verticalSpacer(heightSize = 12)

                    }
                }
            }
        }
    }


}