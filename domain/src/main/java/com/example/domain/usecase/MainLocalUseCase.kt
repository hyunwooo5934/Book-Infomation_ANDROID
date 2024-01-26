package com.example.domain.usecase

import com.example.domain.model.SearchWord
import com.example.domain.repository.LocalDataRepository
import javax.inject.Inject



class MainLocalUseCase @Inject constructor(private val localDataRepository: LocalDataRepository) {

    suspend fun InsertSearchWord (searchWord: SearchWord) {
        localDataRepository.InsertSearchWord(searchWord)
    }

    suspend fun UpdateSearchWord(searchWord: SearchWord) {
        localDataRepository.UpdateSearchWord(searchWord)
    }


    suspend fun getSearchWordList(): List<SearchWord> {
        return localDataRepository.getSearchWordList()
    }

    suspend fun getSelectSearchWord(target: String): List<SearchWord> {
        return localDataRepository.getSelectSearchWord(target)
    }

    suspend fun delete(word : String){
        return localDataRepository.deleteSearchWord(word)
    }

}