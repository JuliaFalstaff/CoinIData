package com.jfalstaff.currencycryptoapp.presentation.ui

import androidx.lifecycle.ViewModel
import com.jfalstaff.currencycryptoapp.domain.GetCoinInfoDetailsUseCase
import com.jfalstaff.currencycryptoapp.domain.GetCoinInfoListUseCase
import com.jfalstaff.currencycryptoapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoDetailsUseCase: GetCoinInfoDetailsUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoDetailsUseCase(fSym)

    init {
        loadDataUseCase()
    }
}