package com.example.data.repository

import android.util.Log
import com.example.domain.model.bestSellerModel
import com.example.domain.repository.bestSellerRepository
import org.jsoup.Jsoup
import javax.inject.Inject

class bestSellerRepositoryImpl @Inject constructor(): bestSellerRepository {

    override suspend fun getBestSellerList(): List<bestSellerModel> {
        var bestSellerList = mutableListOf<bestSellerModel>()

        try{
            val url = "https://www.bookprice.co.kr/best.jsp"
            val document = Jsoup.connect(url).get()
            val contents = document.select("div.best-container div.best-item")

            contents.forEachIndexed { index, content ->

                val data = bestSellerModel(
                    bookName = content.select("li.best-title").text(),
                    bookGrade = content.select("div#rankImg").text(),
                    author = content.select("li.best-author").text(),
                    boolImgUrl = content.select("img").attr("src")
                )

                Log.e("MainActivity",content.select("li.best-title").text())
                Log.e("MainActivity", content.select("div#rankImg").text())
                Log.e("MainActivity",content.select("li.best-author").text())
                Log.e("MainActivity",content.select("img").attr("src"))

                bestSellerList.add(data)

            }


        }catch (e : Exception) {
            e.printStackTrace()
        }


        return bestSellerList.toList()
    }




}