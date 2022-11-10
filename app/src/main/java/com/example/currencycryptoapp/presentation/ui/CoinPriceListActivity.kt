package com.example.currencycryptoapp.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.currencycryptoapp.CryptoApp
import com.example.currencycryptoapp.R
import com.example.currencycryptoapp.databinding.ActivityCoinPriceListBinding
import com.example.currencycryptoapp.domain.CoinInfoEntity
import com.example.currencycryptoapp.presentation.adapters.CoinInfoAdapter
import javax.inject.Inject

class CoinPriceListActivity : AppCompatActivity() {

    private val component by lazy {
        (application as CryptoApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by lazy {
        ActivityCoinPriceListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        setTheme(R.style.Theme_CurrencyCryptoApp)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.listFragmentContainerView, CoinPriceListFragment.newInstance())
                .commit()
        }
    }
}