package com.example.book.repository

import com.example.book.data.model.bookItem
import com.example.book.data.remote.bookService
import javax.inject.Inject

class mainRepository @Inject constructor(private val apiService : bookService){

    suspend fun getItemList(id:String, pwd:String, query:String): List<bookItem> {
        val data = apiService.getBookList(id,pwd,query).body()
        return data?.items?: listOf()
    }

    suspend fun getSearchItemList(id:String, pwd:String, query:String): List<bookItem> {
        val data = apiService.getBookSearchList(id,pwd,query).body()
        return data?.items?: listOf()
    }


}

