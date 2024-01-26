package com.example.domain.repository

import com.example.domain.model.SearchWord


interface LocalDataRepository {
    suspend fun InsertSearchWord(searchWord: SearchWord)
    suspend fun UpdateSearchWord(searchWord: SearchWord)
    suspend fun getSearchWordList(): List<SearchWord>
    suspend fun getSelectSearchWord(target : String): List<SearchWord>
    suspend fun deleteSearchWord(word : String)
}