package com.example.data.api

import com.example.data.model.responseList
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET("v1/search/book.json")
    suspend fun getBookList(
        @Query("query") query : String,
        @Query("display") display : Int,
        @Query("start") start : Int) : responseList


    @GET("v1/search/book_adv.json")
    suspend fun getBookSearchList(
        @Query("d_titl") d_titl : String) : responseList

}