package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.db.entity.SearchWordEntity
import com.example.domain.model.SearchWord

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)//같은 데이터가 있으면 무시
    suspend fun insert(searchWord: SearchWordEntity)

    @Update
    suspend fun update(searchWord: SearchWordEntity)

    @Query("select * from SearchWord order by keyDate desc")
    fun getSearchWord() : List<SearchWordEntity>

    @Query("select * from SearchWord where word = :target")
    fun getSelectSearchWord(target : String) : List<SearchWordEntity>

}