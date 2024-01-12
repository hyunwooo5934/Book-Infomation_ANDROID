package com.example.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "SearchWord")
data class SearchWordEntity(
    @ColumnInfo(name = "keyDate")
    var keyDate : String,

    @PrimaryKey
    @ColumnInfo(name = "word")
    val word : String,
)
