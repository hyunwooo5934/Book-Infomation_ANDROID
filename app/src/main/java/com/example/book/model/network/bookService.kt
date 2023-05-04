package com.example.book.model.network

import com.example.book.model.db.responseList
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface bookService {

    @GET("v1/search/book.json")
    suspend fun getBookList(
        @Header("X-Naver-Client-Id") id : String,
        @Header("X-Naver-Client-Secret") pwd : String,
        @Query("query") query : String) : Response<responseList>

//    @GET("v1/search/book.json")
//    suspend fun getBookList(
//        @Header("X-Naver-Client-Id") id : String,
//        @Header("X-Naver-Client-Secret") pwd : String,
//        @Query("query") query : String,
//        @Query("query") display : Int,
//        @Query("query") start : Int,
//        @Query("query") sort : String) : Response<responseList>

}