package com.example.book.ui.main

import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.book.data.local.searchWord
import com.example.book.repository.mainRepository
import com.example.book.util.Constants.CLIENT_ID
import com.example.book.util.Constants.CLIENT_SECRET
import com.example.book.data.model.bookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: mainRepository) : ViewModel() {

    val _dataList = MutableLiveData<List<bookItem>>()
    val items: LiveData<List<bookItem>> = _dataList

    val searchText = MutableLiveData<String>() // 검색어


    val searchWord = MutableLiveData<List<searchWord>>() // 검색어
    val textList : LiveData<List<searchWord>> = searchWord


    init {
        CoroutineScope(Dispatchers.IO).launch {
                getWord()
        }
    }

    fun getItemList() {
        // 데이터 수신작업
        viewModelScope.launch {
            if(searchText.value.toString() != null && (!searchText.value.toString().equals("null") && !searchText.value.toString().equals(""))){ // 검색어로 조회
                _dataList.value = mainRepository.getSearchItemList(CLIENT_ID,CLIENT_SECRET,searchText.value.toString())

                var currentTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    LocalDateTime.now()
                } else {
                    TODO("VERSION.SDK_INT < O")
                }
                var formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")

                val searchword = searchWord(currentTime.format(formatter),searchText.value.toString())

                withContext(Dispatchers.IO) {
                   launch {
                        // 데이터 존재여부 체크(Y : update, N : insert)
                        if (mainRepository.getSelectSearchWord(searchText.value.toString()).size > 0) {
                            mainRepository.UpdateSearchWord(searchword)
                        } else {
                            mainRepository.InsertSearchWord(searchword)
                            if(mainRepository.getSearchWordList().size > 10) {

                            }

                        }
                    }

                    launch {
                        Thread.sleep(100)
                        getWord()
                    }
                }

            }else{ // 전체조회
                _dataList.value = mainRepository.getItemList(CLIENT_ID,CLIENT_SECRET)
            }

        }
    }


    fun getWord() {
//        CoroutineScope(Dispatchers.IO).launch {
            val wordListSize = mainRepository.getSearchWordList()
            if(wordListSize.size > 0 ) {
                searchWord.postValue(wordListSize)
            }
//        }
    }


}

