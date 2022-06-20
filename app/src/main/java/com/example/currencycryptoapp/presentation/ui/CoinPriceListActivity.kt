package com.example.currencycryptoapp.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.currencycryptoapp.R

class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
//        viewModel.priceList.observe(this, Observer {
//            Log.d("TAG Success in Activity", it.toString())
//        })
        viewModel.getDetailInfo("BTC").observe(this, Observer {
            Log.d("TAG Success in Activity", it.toString())
        })


    }

    override fun onDestroy() {
        super.onDestroy()
    }
}