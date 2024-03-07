package com.example.book.presentation.screen.home

import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.SearchWord
import com.example.domain.model.bestSellerModel
import com.example.domain.usecase.MainUseCase
import com.example.domain.util.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModel() {

    var _bestSeller = MutableLiveData<List<bestSellerModel>>()
    val bestSeller : LiveData<List<bestSellerModel>> = _bestSeller

    init {
        getBestSellerList()
    }

    fun getBestSellerList(){
        CoroutineScope(Dispatchers.IO).launch {

            mainUseCase.getBestSellerList().collectLatest { result ->
                when(result){
                    is ApiResult.Success -> {
                        _bestSeller.postValue(result.value)
                    }

                    is ApiResult.Empty -> {
                        Log.e("SearchResultViewModel","Empty")
//                        _errMsgLiveData.postValue("empty")
                    }

                    is ApiResult.Error -> {
                        Log.e("SearchResultViewModel","Error")
//                        _errMsgLiveData.postValue(result.exception?.message)
                    }
                }
            }
        }
    }


}