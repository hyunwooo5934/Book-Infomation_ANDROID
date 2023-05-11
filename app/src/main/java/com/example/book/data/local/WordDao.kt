package com.example.book.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.book.data.local.searchWord

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)//같은 데이터가 있으면 무시
    suspend fun insert(searchWord: searchWord)

    @Update
    suspend fun update(searchWord: searchWord)

    @Query("select * from searchWord_table order by keyDate desc")
    fun getSearchWord() : List<searchWord>

    @Query("select * from searchWord_table where word = :target")
    fun getSelectSearchWord(target : String) : List<searchWord>

}