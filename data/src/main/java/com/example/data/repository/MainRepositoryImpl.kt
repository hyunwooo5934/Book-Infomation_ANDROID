package com.example.data.repository

import com.example.data.api.BookService
import com.example.data.mapper.CommonMapper
import com.example.domain.model.bookModel
import com.example.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val bookService: BookService
) : MainRepository {

    override suspend fun getItemList(query: String, start: Int): List<bookModel> {
        val data = bookService.getBookList(query,10,start).body()
        return CommonMapper.bookMapper(data?.items ?: listOf())
    }

    override suspend fun getSearchItemList(query: String): List<bookModel> {
        val data = bookService.getBookSearchList(query).body()
        return CommonMapper.bookMapper(data?.items ?: listOf())
    }

}