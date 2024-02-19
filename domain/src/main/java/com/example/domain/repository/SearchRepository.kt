package com.example.domain.repository

import com.example.domain.model.bookModel
import com.example.domain.util.ApiResult
import kotlinx.coroutines.flow.Flow


interface SearchRepository {

    suspend fun getItemList(query: String, start : Int): Flow<ApiResult<List<bookModel>>>
//    suspend fun getItemList(query: String, start : Int): List<bookModel>

    suspend fun getSearchItemList(query: String): Flow<ApiResult<List<bookModel>>>

}