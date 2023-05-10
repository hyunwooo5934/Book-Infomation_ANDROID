package com.example.book.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.book.data.local.searchWord

@Dao
interface wordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)//같은 데이터가 있으면 무시
    suspend fun insert(searchWord: searchWord)

    @Query("select word from searchWord_table order by idx desc")
     fun getSearchWord() : LiveData<List<searchWord>>

}