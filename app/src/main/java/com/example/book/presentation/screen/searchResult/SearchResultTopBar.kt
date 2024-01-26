package com.example.book.presentation.screen.searchResult

import android.annotation.SuppressLint
import android.webkit.WebSettings.TextSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.book.R
import com.example.book.presentation.navigation.Screen
import java.net.URLEncoder

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchResultTopBar(
    navHostController: NavHostController,
    searchWord: String?
) {

    Column (
        modifier = Modifier.padding(horizontal = 10.dp)
    ){
        TopAppBar(
            title = {
                Text(
                    text = searchWord!!,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .clickable {
                            val word = URLEncoder.encode(searchWord!!, Charsets.UTF_8.toString())
                            navHostController.navigate("search_screen/$word")
                        }
                )
            },

            /** 왼쪽 메뉴 아이콘 & 기능 */
            navigationIcon = {
                IconButton(onClick = {
//                    navHostController.navigate(Screen.Search.route)
                    navHostController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            },

            actions = {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "word"
                )
            }
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(1.dp)
                .background(Color.LightGray)
        )


    }

}


//@Preview
//@Composable
//fun ToolbarWithTitleAndNavigationIconPreview(){
//    BookExTheme {
//        MainTopBar()
//    }
//}