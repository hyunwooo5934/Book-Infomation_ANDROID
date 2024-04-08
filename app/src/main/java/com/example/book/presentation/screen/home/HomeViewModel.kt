package com.example.book.presentation.screen.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.bestSellerModel
import com.example.domain.usecase.MainUseCase
import com.example.domain.util.ApiResult
import com.google.firebase.Firebase
import com.google.firebase.app
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModel() {

    var _bestSeller = MutableLiveData<List<bestSellerModel>>()
    val bestSeller : LiveData<List<bestSellerModel>> = _bestSeller

    var _loadingLiveData = MutableLiveData<Boolean>(false)
    val loadingLiveData : MutableLiveData<Boolean> = _loadingLiveData


    init {
        getBestSellerList()
    }

    private val db = Firebase.database
    private val myData = db.getReference("first")

    fun writeValue(data: String){
        myData.setValue(data)
    }

    fun readValue(){
        myData.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.e("TAG_DB", "onDataChange : ${snapshot.value}")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getBestSellerList(){
        _loadingLiveData.postValue(true)

        CoroutineScope(Dispatchers.IO).launch {

            mainUseCase.getBestSellerList().collectLatest { result ->
                when(result){
                    is ApiResult.Success -> {
                        _bestSeller.postValue(result.value)
                        _loadingLiveData.postValue(false)
                    }

                    is ApiResult.Empty -> {
                        Log.e("SearchResultViewModel","Empty")
//                        _errMsgLiveData.postValue("empty")
                        _loadingLiveData.postValue(false)
                    }

                    is ApiResult.Error -> {
                        Log.e("SearchResultViewModel","Error")
//                        _errMsgLiveData.postValue(result.exception?.message)
                        _loadingLiveData.postValue(false)
                    }
                }
            }
        }
    }


}