package com.example.book.repository

import com.example.book.data.local.WordDao
import com.example.book.data.local.searchWord
import com.example.book.data.model.bookItem
import com.example.book.data.remote.bookService
import javax.inject.Inject

class mainRepository @Inject constructor(
    private val apiService: bookService,
    private val Dao: WordDao
) {
    suspend fun getItemList(id: String, pwd: String, query: String, start : Int): List<bookItem> {
        val data = apiService.getBookList(id, pwd, query,10,start).body()
        return data?.items ?: listOf()
    }

    suspend fun getSearchItemList(id: String, pwd: String, query: String): List<bookItem> {
        val data = apiService.getBookSearchList(id, pwd, query).body()
        return data?.items ?: listOf()
    }

    suspend fun InsertSearchWord(searchWord: searchWord) = Dao.insert(searchWord)

    suspend fun UpdateSearchWord(searchWord: searchWord) = Dao.update(searchWord)

    fun getSearchWordList(): List<searchWord> {
        return Dao.getSearchWord()
    }

    fun getSelectSearchWord(target : String): List<searchWord> {
        return Dao.getSelectSearchWord(target)
    }

}

