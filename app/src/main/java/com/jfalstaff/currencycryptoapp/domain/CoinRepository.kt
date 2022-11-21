package com.jfalstaff.currencycryptoapp.domain

import androidx.lifecycle.LiveData

interface CoinRepository {
    fun getPriceList(): LiveData<List<CoinInfoEntity>>
    fun getCoinInfoDetails(fSym: String): LiveData<CoinInfoEntity>
    fun loadData()
}