package com.example.book

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.book.presentation.navigation.NavGraph

import com.example.cleanarchitecturesample2.ui.theme.BookExTheme
import com.example.domain.model.bestSellerModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.select.Elements





@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BookExTheme {
                navHostController = rememberNavController()
                NavGraph(navHostController = navHostController)
            }
        }


//        CoroutineScope(Dispatchers.IO).launch {
//            try{
//                val url = "https://www.bookprice.co.kr/best.jsp"
//                val document = Jsoup.connect(url).get()
//                val contents = document.select("div.best-container div.best-item")
//
////                val contents: Elements = document.getElementsByAttributeValue("class", "best-container")
//
//
////                val url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%82%A0%EC%94%A8"
////                val document = Jsoup.connect(url).get()
////                val contents: Elements = document.getElementsByAttributeValue("class", "temperature_text")
//
//
//                contents.forEachIndexed { index, content ->
//
//                    val data = bestSellerModel(
//                        bookName = content.select("li.best-title").text(),
//                        bookGrade = content.select("div#rankImg").text(),
//                        author = content.select("li.best-author").text(),
//                        boolImgUrl = content.select("img").attr("src")
//                    )
//
//                    Log.e("MainActivity",content.select("li.best-title").text())
//                    Log.e("MainActivity", content.select("div#rankImg").text())
//                    Log.e("MainActivity",content.select("li.best-author").text())
//                    Log.e("MainActivity",content.select("img").attr("src"))
//
//                }
//
//
//            }catch (e : Exception) {
//                e.printStackTrace()
//            }
//        }




    }

}