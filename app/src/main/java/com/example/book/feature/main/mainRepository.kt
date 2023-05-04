package com.example.book.feature.main

import android.util.Log
import com.example.book.model.db.bookItem
import com.example.book.model.network.bookService
import javax.inject.Inject

class mainRepository @Inject constructor(private val apiService : bookService){

    suspend fun getItemList(id:String, pwd:String, query:String): List<bookItem> {
        val data = apiService.getBookList(id,pwd,query).body()
        return data?.items?: listOf()
    }

}

