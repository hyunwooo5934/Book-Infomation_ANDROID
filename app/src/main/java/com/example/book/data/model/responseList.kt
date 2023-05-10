package com.example.book.data.model

import com.google.gson.annotations.SerializedName

data class responseList(
    @SerializedName("lastBuildDate")
    val lastBuildDate : String,

    @SerializedName("total")
    val total : String,

    @SerializedName("start")
    val start : String,

    @SerializedName("display")
    val display : String,

    @SerializedName("items")
    val items : List<bookItem>
)
