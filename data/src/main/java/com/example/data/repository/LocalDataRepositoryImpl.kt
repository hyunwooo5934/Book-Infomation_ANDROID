package com.example.data.repository

import com.example.data.db.WordDao
import com.example.data.mapper.CommonMapper
import com.example.domain.model.SearchWord
import com.example.domain.repository.LocalDataRepository
import javax.inject.Inject



class LocalDataRepositoryImpl @Inject constructor(
    private val wordDao: WordDao
) : LocalDataRepository{
    override suspend fun InsertSearchWord(searchWord: SearchWord) {
        wordDao.insert(CommonMapper.itemToEntity(searchWord))
    }

    override suspend fun UpdateSearchWord(searchWord: SearchWord) {
        wordDao.update(CommonMapper.itemToEntity(searchWord))
    }

    override suspend fun getSearchWordList(): List<SearchWord> {
        return CommonMapper.itemToModel(wordDao.getSearchWord())
    }

    override suspend fun getSelectSearchWord(target: String): List<SearchWord> {
        return CommonMapper.itemToModel(wordDao.getSelectSearchWord(target))
    }


}