package com.example.domain.repository

import com.example.domain.entity.bookItem


interface MainRepository {

    suspend fun getItemList(query: String, start : Int): List<bookItem>

    suspend fun getSearchItemList(query: String): List<bookItem>

}