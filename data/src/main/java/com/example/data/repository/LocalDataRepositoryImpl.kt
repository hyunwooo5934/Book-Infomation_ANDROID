package com.example.data.repository

import com.example.data.db.SearchWord
import com.example.data.db.WordDao
import com.example.domain.repository.LocalDataRepository
import javax.inject.Inject


class LocalDataRepositoryImpl @Inject constructor(private val Dao: WordDao
) : LocalDataRepository {
    override suspend fun InsertSearchWord(searchWord: SearchWord) = Dao.insert(searchWord)

    override suspend fun UpdateSearchWord(searchWord: SearchWord) = Dao.update(searchWord)

    override suspend fun getSearchWordList(): List<SearchWord> {
        return Dao.getSearchWord()
    }

    override suspend fun getSelectSearchWord(target : String): List<SearchWord> {
        return Dao.getSelectSearchWord(target)
    }


}