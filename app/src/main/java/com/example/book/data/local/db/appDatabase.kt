package com.example.book.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.book.data.local.searchWord
import com.example.book.data.local.wordDao

@Database(entities = [searchWord::class], version = 2,exportSchema = false)
abstract class appDatabase : RoomDatabase() {

    abstract fun WordDao() : wordDao
}