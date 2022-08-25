package com.example.currencycryptoapp.presentation.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencycryptoapp.data.repository.CoinRepositoryImpl
import com.example.currencycryptoapp.domain.GetCoinInfoDetailsUseCase
import com.example.currencycryptoapp.domain.GetCoinInfoListUseCase
import com.example.currencycryptoapp.domain.LoadDataUseCase
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinInfoDetailsUseCase = GetCoinInfoDetailsUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoDetailsUseCase(fSym)

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }
}