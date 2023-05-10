package com.example.book.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.book.repository.mainRepository
import com.example.book.util.Constants.CLIENT_ID
import com.example.book.util.Constants.CLIENT_SECRET
import com.example.book.data.model.bookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: mainRepository) : ViewModel() {

    val _dataList = MutableLiveData<List<bookItem>>()
    val items: MutableLiveData<List<bookItem>> = _dataList

    val searchText = MutableLiveData<String>() // 검색어


    fun getItemList() {
        // 데이터 수신작업
        viewModelScope.launch {

            if(searchText != null && !searchText.value.toString().equals("")){ // 검색어로 조회
                items.value = mainRepository.getSearchItemList(CLIENT_ID,CLIENT_SECRET,searchText.value.toString())
            }else{ // 전체조회
                items.value = mainRepository.getItemList(CLIENT_ID,CLIENT_SECRET,"text")
            }

        }
    }


}

