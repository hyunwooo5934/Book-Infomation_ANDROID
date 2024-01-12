package com.example.domain.usecase

import com.example.domain.model.bookModel
import com.example.domain.repository.MainRepository
import javax.inject.Inject

class MainUseCase @Inject constructor(private val mainRepository: MainRepository) {

    suspend fun getItemList(query: String, start : Int): List<bookModel> {
            return mainRepository.getItemList(query,start)
        }

        suspend fun getSearchItemList(query: String): List<bookModel> {
            return mainRepository.getSearchItemList(query)
    }

}