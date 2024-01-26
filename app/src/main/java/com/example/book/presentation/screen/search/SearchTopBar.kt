package com.example.book.presentation.screen.search

import android.annotation.SuppressLint
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
fun SearchResultTopBar(navHostController: NavHostController, searchWord : String ?= null, viewModel : SearchViewModel = hiltViewModel()){

    remember { mutableStateOf(if(searchWord.isNullOrEmpty().not()) searchWord!! else "") }


    var textState = remember { mutableStateOf(if(searchWord.isNullOrEmpty().not()) searchWord!! else "") }
    val focusRequester = remember { FocusRequester() }

    Column (
        modifier = Modifier.padding(horizontal = 10.dp)
    ){
        TopAppBar(
            title = {
                TextField(
                    value = textState.value,
                    onValueChange = { textValue -> textState.value = textValue },
                    placeholder = { Text(stringResource(id = R.string.main_text))},
                    textStyle = TextStyle.Default.copy(fontSize = 13.sp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(id = R.color.white),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier.clickable { viewModel.textFocusOn() }.focusRequester(focusRequester),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {
                        val word = URLEncoder.encode(textState.value, Charsets.UTF_8.toString())
                        navHostController.popBackStack()
                        navHostController.navigate("search_result_screen/$word"){
                            launchSingleTop = true
                        }
                    })
                )

                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }

            },

            /** 왼쪽 메뉴 아이콘 & 기능 */
            navigationIcon = {
            IconButton(onClick = {
                navHostController.popBackStack()
//                navHostController.navigate(Screen.Home.route) {
//                    popUpTo(navHostController.graph.id){
//                        inclusive = true
//                    }
//                }

            }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
    },

            actions = {
                    IconButton(onClick = {
                        navHostController.navigate(Screen.SearchWord.route)
                    }){
                        Icon(imageVector = Icons.Filled.Menu,
                            contentDescription = "word")
                    }

            }
        )

        Spacer(modifier = Modifier
            .fillMaxWidth(1f)
            .height(1.dp)
            .background(Color.LightGray))


    }

}


//@Preview
//@Composable
//fun ToolbarWithTitleAndNavigationIconPreview(){
//    BookExTheme {
//        MainTopBar()
//    }
//}