package com.example.book.ui.main

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.db.SearchWord
import com.example.domain.usecase.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainUseCase: MainUseCase) : ViewModel() {

    val _dataList = MutableLiveData<List<com.example.data.model.bookItem>>()
    val items: LiveData<List<com.example.data.model.bookItem>> = _dataList

    val searchText = MutableLiveData<String>() // 검색어


    val searchWord = MutableLiveData<List<SearchWord>>() // 검색어
    val textList : LiveData<List<SearchWord>> = searchWord


    init {
        CoroutineScope(Dispatchers.IO).launch {
                getWord()
        }
    }

    fun getItemList() {
        // 데이터 수신작업
        viewModelScope.launch {
            if(searchText.value.toString() != null && (!searchText.value.toString().equals("null") && !searchText.value.toString().equals(""))){ // 검색어로 조회
                _dataList.value = mainUseCase.getSearchItemList(searchText.value.toString())

                var currentTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    LocalDateTime.now()
                } else {
                    TODO("VERSION.SDK_INT < O")
                }
                var formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")

                val searchword = SearchWord(currentTime.format(formatter),searchText.value.toString())

                withContext(Dispatchers.IO) {
                   launch {
                        // 데이터 존재여부 체크(Y : update, N : insert)
                        if (mainUseCase.getSelectSearchWord(searchText.value.toString()).size > 0) {
                            mainUseCase.UpdateSearchWord(searchword)
                        } else {
                            mainUseCase.InsertSearchWord(searchword)
                            if(mainUseCase.getSearchWordList().size > 10) {

                            }

                        }
                    }

                    launch {
                        Thread.sleep(100)
                        getWord()
                    }
                }

            }else{ // 전체조회
                _dataList.value = mainUseCase.getItemList(CLIENT_ID,CLIENT_SECRET)
            }

        }
    }


    fun getWord() {
        CoroutineScope(Dispatchers.IO).launch {
            val wordListSize = mainUseCase.getSearchWordList()
            if(wordListSize.size > 0 ) {
                searchWord.postValue(wordListSize)
            }
        }
    }


}

