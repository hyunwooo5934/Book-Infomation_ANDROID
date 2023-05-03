package com.example.book.model.db

import java.util.Date

data class bookItem(
    val title : String,
    val link : String,
    val image : String,
    val author : String,
    val discount : Int,
    val publisher : String,
    val isbn : Int,
    val description : String,
    val pubdate : Date,
)
