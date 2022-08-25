package com.example.currencycryptoapp.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.currencycryptoapp.data.model.CoinPriceInfo
import com.example.currencycryptoapp.databinding.ActivityCoinPriceListBinding
import com.example.currencycryptoapp.presentation.adapters.CoinInfoAdapter

class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    private var binding: ActivityCoinPriceListBinding? = null
    private var adapter:  CoinInfoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinPriceListBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        adapter = CoinInfoAdapter(this)
        adapter?.onClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(this@CoinPriceListActivity, coinPriceInfo.fromSymbol)
                startActivity(intent)
            }
        }
        binding?.recyclerViewCoinPriceList?.adapter = adapter
        binding?.recyclerViewCoinPriceList
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this, Observer {
            adapter?.coinInfoList = it
        })
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}