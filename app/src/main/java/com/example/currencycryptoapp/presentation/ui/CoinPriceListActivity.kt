package com.example.currencycryptoapp.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.currencycryptoapp.R
import com.example.currencycryptoapp.data.CoinPriceInfo
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
                val intent = Intent(this@CoinPriceListActivity, CoinDetailActivity::class.java)
                intent.putExtra(CoinDetailActivity.EXTRA_FROM_SYMBOL, coinPriceInfo.fromSymbol)
                startActivity(intent)
                Toast.makeText(this@CoinPriceListActivity, "item: ${coinPriceInfo.fromSymbol}", Toast.LENGTH_SHORT).show()
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