package com.example.book.presentation.screen.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
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