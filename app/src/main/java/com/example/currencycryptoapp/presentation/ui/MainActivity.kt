package com.example.currencycryptoapp.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.currencycryptoapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.loadData()


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}