package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.entity.SearchWordEntity

@Database(entities = [SearchWordEntity::class], version = 1,exportSchema = false)
abstract class appDatabase : RoomDatabase() {
    abstract fun WordDao() : WordDao

}