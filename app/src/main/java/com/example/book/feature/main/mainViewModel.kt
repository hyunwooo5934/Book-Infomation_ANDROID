package com.example.book.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.book.model.db.bookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class mainViewModel @Inject constructor() : ViewModel() {

    private val _dataList = MutableLiveData<List<bookItem>>()
    val items : LiveData<List<bookItem>> = _dataList


    fun getItemList() {
        // 데이터 수신작업
//        items.value =
    }


}