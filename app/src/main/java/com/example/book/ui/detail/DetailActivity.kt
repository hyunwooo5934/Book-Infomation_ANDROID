package com.example.book.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.book.R
import com.example.book.databinding.ActivityDetailBinding
import com.example.book.util.CustomWebViewClient

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding
    private val binding get() = detailBinding!! // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언

    private lateinit var getLink : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail)


        val secondIntent = intent
        getLink = secondIntent.getStringExtra("link").toString()

        binding.bookLinkView.run {
            webViewClient = CustomWebViewClient()
            loadUrl(getLink)
        }
    }


    // webview back button 처리.
    override fun onBackPressed() {
        if(binding.bookLinkView.canGoBack()){
            binding.bookLinkView.goBack()
        }else{
            super.onBackPressed()
        }

    }
}