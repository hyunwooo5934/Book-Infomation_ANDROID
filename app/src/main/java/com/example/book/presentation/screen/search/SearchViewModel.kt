package com.example.book.presentation.screen.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.SearchWord
import com.example.domain.usecase.MainLocalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val mainLocalUseCase: MainLocalUseCase
) : ViewModel() {

    var _SearchWord = MutableLiveData<List<SearchWord>>()
    val SearchWord : LiveData<List<SearchWord>> = _SearchWord

    val _EdtFocusLiveData = MutableLiveData<Boolean>(false)
    val EdtFocusLiveData : LiveData<Boolean> = _EdtFocusLiveData

    fun getWord(){
        CoroutineScope(Dispatchers.IO).launch {
            val wordListSize = mainLocalUseCase.getSearchWordList()
            if(wordListSize.isNotEmpty()){
                _SearchWord.postValue(wordListSize)
                wordListSize.forEach {
                    Log.e("SearchWordViewModel", it.word)
                }
            }
        }
    }

    fun deleteWord(word : String){
        viewModelScope.launch {
            mainLocalUseCase.delete(word)
            getWord()
        }
    }

    init {
        CoroutineScope(Dispatchers.IO).launch {
            getWord()
        }
    }

    fun textFocusOn(){
        _EdtFocusLiveData.value = true
    }

}