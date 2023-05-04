package com.example.book.feature.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.book.global.Constants.CLIENT_ID
import com.example.book.global.Constants.CLIENT_SECRET
import com.example.book.model.db.bookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: mainRepository) : ViewModel() {

    val _dataList = MutableLiveData<List<bookItem>>()
    val items: MutableLiveData<List<bookItem>> = _dataList


    fun getItemList() {
        // 데이터 수신작업
        viewModelScope.launch {
            items.value = mainRepository.getItemList(CLIENT_ID,CLIENT_SECRET,"text")
        }
    }


}

