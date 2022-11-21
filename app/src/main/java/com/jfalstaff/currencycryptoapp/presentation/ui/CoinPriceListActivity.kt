package com.jfalstaff.currencycryptoapp.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jfalstaff.currencycryptoapp.CryptoApp
import com.jfalstaff.currencycryptoapp.R
import com.jfalstaff.currencycryptoapp.databinding.ActivityCoinPriceListBinding
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