package com.example.book.presentation.screen.detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.net.URLDecoder
import kotlin.text.Charsets.UTF_8


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(webUrl : String?){


    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colorScheme.background


    SideEffect {
        systemUiController.setSystemBarsColor(
            color = systemBarColor
        )
    }


    Scaffold (
        content = {
            Column(modifier = Modifier.padding(it)) {
                if(webUrl.isNullOrEmpty().not()){
                    val urlStr = URLDecoder.decode(webUrl!!,UTF_8.toString())
                    Log.e("DetailScreen",urlStr)
                    DetailContent(webUrl = urlStr)
                }
            }
        }
    )


}


