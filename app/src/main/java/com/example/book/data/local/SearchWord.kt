package com.example.book.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "searchWord_table")
data class searchWord(


    @ColumnInfo(name = "keyDate")
    var keyDate : String,

    @PrimaryKey
    @ColumnInfo(name = "word")
    val word : String,

)
