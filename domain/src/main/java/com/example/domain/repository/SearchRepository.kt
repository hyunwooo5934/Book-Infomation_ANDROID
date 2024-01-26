package com.example.domain.repository

import com.example.domain.model.bookModel


interface SearchRepository {

    suspend fun getItemList(query: String, start : Int): List<bookModel>

    suspend fun getSearchItemList(query: String): List<bookModel>

}