package com.example.book.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil

import com.example.book.R
import com.example.book.adapter.MainAdapter
import com.example.book.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val binding get() = mBinding!! // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언

    private lateinit var mainAdapter: MainAdapter

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        mainAdapter = MainAdapter(this)
        binding.recyclerView.adapter = mainAdapter
        binding.viewModel = viewModel

        viewModel.items.observe(this) { data ->
            data.let {
                // 리스트 갱신작업
                Log.d("MainActivity", data.toString())
                mainAdapter.update(it)
            }
        }

    }


}