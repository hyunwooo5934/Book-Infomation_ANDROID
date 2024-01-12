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

    private lateinit var mainBinding: ActivityMainBinding

    private val mainAdapter by lazy {
        MainAdapter(this@MainActivity)
    }

    private val searchAdapter by lazy {
        searchWordAdapter(this@MainActivity,this@MainActivity)
    }

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
        mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        mainBinding.apply {
            recyclerView.adapter = mainAdapter
            wordRecyclerView.adapter = searchAdapter
            mainViewModel = viewModel
        }
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
        mainBinding.apply {
            editText.setText(word)
            viewModel?.let {
                viewModel.getItemList()
            }
        }
    }

}