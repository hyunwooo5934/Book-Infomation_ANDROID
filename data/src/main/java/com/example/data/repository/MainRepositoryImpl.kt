package com.example.data.repository

import com.example.data.api.BookService
import com.example.domain.entity.bookItem
import com.example.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val bookService: BookService
) : MainRepository {

    override suspend fun getItemList(query: String, start: Int): List<bookItem> {
        val data = bookService.getBookList(query,10,start).body()
        return data?.items ?: listOf()
    }

    override suspend fun getSearchItemList(query: String): List<bookItem> {
        val data = bookService.getBookSearchList(query).body()
        return data?.items ?: listOf()
    }

}