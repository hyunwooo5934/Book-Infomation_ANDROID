package com.example.domain.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.lang.Exception


sealed class ApiResult<out T> {
    data class Success<out T>(val value: T) : ApiResult<T>()
    object Empty : ApiResult<Nothing>()
    data class Error(val code : Int? = null, val exception: Throwable? = null) : ApiResult<Nothing>()
}


fun <T> safeFlow(apiFnc : suspend () -> T) : Flow<ApiResult<T>> = flow {
    try{
        emit(ApiResult.Success(apiFnc.invoke()))
    }catch (e: NullPointerException){
        emit(ApiResult.Empty)
    }catch (e : HttpException){
        emit(ApiResult.Error(code = e.code(), exception = e))
    }catch (e : Exception){
        emit(ApiResult.Error(exception = e))
    }
}