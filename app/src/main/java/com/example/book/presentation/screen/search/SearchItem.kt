package com.example.book.presentation.screen.search

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.book.presentation.navigation.Screen
import com.example.domain.model.SearchWord
import java.net.URLEncoder


@Composable
fun SearchItem(
    navController: NavHostController,
    item: SearchWord,
    viewModel: SearchViewModel = hiltViewModel()
) {

    searchItemView(
        item = item,
        viewModel = viewModel,
        modifier = Modifier.clickable {
            val word = URLEncoder.encode(item.word, Charsets.UTF_8.toString())
            navController.popBackStack()
            navController.navigate("search_result_screen/$word")
        })
}


@Composable
fun searchItemView(
    item: SearchWord,
    viewModel: SearchViewModel,
    modifier: Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(1f)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(1f)
        ) {

            Text(text = item.word, textAlign = TextAlign.Center)
//            Text(text = item.keyDate, textAlign = TextAlign.Center)
            IconButton(onClick = {
                viewModel.deleteWord(item.word)
            }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "delete"
                )
            }
        }
    }

}