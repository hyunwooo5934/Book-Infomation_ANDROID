package com.example.data.repository

import com.example.data.api.BookService
import com.example.data.mapper.CommonMapper
import com.example.domain.model.bookModel
import com.example.domain.repository.SearchRepository
import com.example.domain.util.ApiResult
import com.example.domain.util.safeFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val bookService: BookService
) : SearchRepository {

    override suspend fun getItemList(query: String, start: Int): Flow<ApiResult<List<bookModel>>> = safeFlow {
        val data = bookService.getBookList(query,10,start)
        CommonMapper.bookMapper(data.items)
    }

    override suspend fun getSearchItemList(query: String): Flow<ApiResult<List<bookModel>>> = safeFlow {
        val data = bookService.getBookSearchList(query)
        CommonMapper.bookMapper(data.items)
    }


}