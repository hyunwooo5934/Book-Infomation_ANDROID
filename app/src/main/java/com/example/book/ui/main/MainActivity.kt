package com.example.book.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil

import com.example.book.R
import com.example.book.adapter.MainAdapter
import com.example.book.adapter.searchWordAdapter
import com.example.book.databinding.ActivityMainBinding
import com.example.book.util.reSearchClick
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), reSearchClick {

    private lateinit var mBinding: ActivityMainBinding
    private val binding get() = mBinding!! // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언

    private lateinit var mainAdapter: MainAdapter // 도서목록 리스트 어댑터
    private lateinit var searchAdapter: searchWordAdapter // 검색어 리스트 어댑터


    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInit()


    }

    private fun setInit(){
        initView()
        setobserver()
    }

    private fun initView(){
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mainAdapter = MainAdapter(this)
        searchAdapter = searchWordAdapter(this, this)
        binding.recyclerView.adapter = mainAdapter
        binding.wordRecyclerView.adapter = searchAdapter
        binding.viewModel = viewModel
    }


    private fun setobserver(){
        viewModel.apply {
            textList.observe(this@MainActivity) { data ->
                data.let {
                    searchAdapter.update(it)
                }
            }

            items.observe(this@MainActivity) { data ->
                data.let {
                    // 리스트 갱신작업
                    mainAdapter.update(it)
                }
            }
        }


    }

    override fun reSearch(word: String) {
        binding.editText.setText(word)
        viewModel?.let {
            viewModel.getItemList()
        }
    }

}