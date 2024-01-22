package com.example.book.presentation.screen.main

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.book.R
import com.example.cleanarchitecturesample2.ui.theme.BookExTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(viewModel : MainViewModel = hiltViewModel()){

    val textState = remember { mutableStateOf("") }

    Box {
        TopAppBar(
            title = {
                TextField(
                    value = textState.value,
                    onValueChange = { textValue -> textState.value = textValue },
                    placeholder = { Text(stringResource(id = R.string.main_text))},
                    textStyle = TextStyle.Default.copy(fontSize = 13.sp),
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(containerColor = colorResource(id = R.color.white)),
                    modifier = Modifier.clickable {
                        viewModel.textFocusOn()
                    }
                )
            },

            /** 왼쪽 메뉴 아이콘 & 기능 */
//            navigationIcon = {
//                IconButton(onClick = { viewModel.getItemList(textState.value)}) {
//                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Menu")
//                }
//            },

            actions = {
                IconButton(onClick = { viewModel.getItemList(textState.value) }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "MoreVert"
                    )
                }
            }

        )

    }

}


@Preview
@Composable
fun ToolbarWithTitleAndNavigationIconPreview(){
    BookExTheme {
        MainTopBar()
    }
}