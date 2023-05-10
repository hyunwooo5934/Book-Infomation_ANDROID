package com.example.book.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "searchWord_table")
data class searchWord(

    @PrimaryKey(autoGenerate = true) val idx : Int,
    val word : String
)
