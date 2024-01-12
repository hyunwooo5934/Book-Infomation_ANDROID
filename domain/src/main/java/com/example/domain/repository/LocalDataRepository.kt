package com.example.domain.repository



interface LocalDataRepository {
    suspend fun InsertSearchWord(searchWord: SearchWord)
    suspend fun UpdateSearchWord(searchWord: searchWord)
    suspend fun getSearchWordList(): List<searchWord>
    suspend fun getSelectSearchWord(target : String): List<searchWord>
}