package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.book.data.local.WordDao
import com.example.book.data.local.searchWord

@Database(entities = [searchWord::class], version = 1,exportSchema = false)
abstract class appDatabase : RoomDatabase() {
    abstract fun WordDao() : WordDao

}