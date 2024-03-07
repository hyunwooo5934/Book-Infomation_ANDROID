package com.example.domain.repository

import com.example.domain.model.bestSellerModel
import com.example.domain.model.bookModel
import com.example.domain.util.ApiResult
import kotlinx.coroutines.flow.Flow


interface bestSellerRepository {

    suspend fun getBestSellerList() : List<bestSellerModel>

}