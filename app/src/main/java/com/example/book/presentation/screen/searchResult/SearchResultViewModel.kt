package com.example.book.presentation.screen.searchResult

import android.os.Build
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.SearchWord
import com.example.domain.model.bookModel
import com.example.domain.usecase.MainLocalUseCase
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
class SearchResultViewModel @Inject constructor(
    private val mainUseCase: MainUseCase,
    private val mainLocalUseCase: MainLocalUseCase
) : ViewModel() {

    val _dataList = MutableLiveData<List<bookModel>>()
    val dataList: LiveData<List<bookModel>> = _dataList

    val searchText = MutableLiveData<String>() // 검색어

    val _EdtFocusLiveData = MutableLiveData<Boolean>(false)
    val EdtFocusLiveData: LiveData<Boolean> = _EdtFocusLiveData

    val searchWord = MutableLiveData<List<SearchWord>>() // 검색어
    val textList: LiveData<List<SearchWord>> = searchWord

    val _errMsgLiveData = MutableLiveData<String>()
    val errMSgLiveData get() = _errMsgLiveData

//    init {
//        CoroutineScope(Dispatchers.IO).launch {
//                getWord()
//        }
//    }

    fun getItemList(searchText: String) {
        // 데이터 수신작업
        viewModelScope.launch {
            if (searchText.isNullOrEmpty().not()) { // 검색어로 조회

                mainUseCase.getSearchItemList(searchText).collectLatest { result ->
                    Log.e("SearchResultViewModel","getSearchItemList")
                    when(result){
                        is ApiResult.Success -> {
                            Log.e("SearchResultViewModel","Success")
                            _dataList.postValue(result.value)

                            var currentTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                LocalDateTime.now()
                            } else {
                                TODO("VERSION.SDK_INT < O")
                            }
                            var formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")

                            val searchword = SearchWord(currentTime.format(formatter), searchText)

                            withContext(Dispatchers.IO) {
                                launch {
                                    // 데이터 존재여부 체크(Y : update, N : insert)
                                    if (mainLocalUseCase.getSelectSearchWord(searchText).isNotEmpty()) {
                                        mainLocalUseCase.UpdateSearchWord(searchword)
                                    } else {
                                        mainLocalUseCase.InsertSearchWord(searchword)
                                        if (mainLocalUseCase.getSearchWordList().size > 10) {

                                        }
                                    }
                                }

                                launch {
                                    Thread.sleep(100)
                                    getWord()
                                }
                            }
                        }

                        is ApiResult.Empty -> {
                            Log.e("SearchResultViewModel","Empty")
                            _errMsgLiveData.postValue("empty")
                        }

                        is ApiResult.Error -> {
                            Log.e("SearchResultViewModel","Error")
                            _errMsgLiveData.postValue(result.exception?.message)
                        }
                    }
                }
            } else { // 전체조회
//                _dataList.value = mainUseCase.getItemList("",0)

                mainUseCase.getItemList("", 0).collectLatest { result ->
                    when (result) {
                        is ApiResult.Success -> {
                            _dataList.postValue(result.value)
                        }

                        is ApiResult.Empty -> {
                            _errMsgLiveData.postValue("empty")
                        }

                        is ApiResult.Error -> {
                            _errMsgLiveData.postValue(result.exception?.message)
                        }
                    }
                }
            }
        }
    }


    fun getWord() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val wordListSize = mainLocalUseCase.getSearchWordList()
                if (wordListSize.isNotEmpty()) {
                    searchWord.postValue(wordListSize)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun textFocusOn() {
        Log.e("mainViewModel", "textFocusOn")
        _EdtFocusLiveData.value = true
    }


}

