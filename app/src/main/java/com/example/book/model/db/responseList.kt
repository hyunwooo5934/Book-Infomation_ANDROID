package com.example.book.model.db

data class responseList(
    val lastBuildDate : String,
    val total : String,
    val start : String,
    val display : String,
    val data : List<bookItem>
)
