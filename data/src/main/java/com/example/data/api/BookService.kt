package com.example.data.api

import com.example.data.model.responseList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET("v1/search/book.json")
    suspend fun getBookList(
        @Query("query") query : String,
        @Query("display") display : Int,
        @Query("start") start : Int) : Response<responseList>

//    @GET("v1/search/book.json")
//    suspend fun getBookList(
//        @Header("X-Naver-Client-Id") id : String,
//        @Header("X-Naver-Client-Secret") pwd : String,
//        @Query("query") query : String,
//        @Query("query") display : Int,
//        @Query("query") start : Int,
//        @Query("query") sort : String) : Response<responseList>


    @GET("v1/search/book_adv.json")
    suspend fun getBookSearchList(
        @Query("d_titl") d_titl : String) : Response<responseList>

}