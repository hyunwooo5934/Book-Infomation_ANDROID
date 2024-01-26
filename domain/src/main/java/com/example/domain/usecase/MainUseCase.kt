package com.example.domain.usecase

import com.example.domain.model.bookModel
import com.example.domain.repository.SearchRepository
import javax.inject.Inject

class MainUseCase @Inject constructor(private val searchRepository: SearchRepository) {

    suspend fun getItemList(query: String, start : Int): List<bookModel> {
            return searchRepository.getItemList(query,start)
        }

        suspend fun getSearchItemList(query: String): List<bookModel> {
            return searchRepository.getSearchItemList(query)
    }

}