package com.example.currencycryptoapp.domain

import javax.inject.Inject

class GetCoinInfoListUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke() = repository.getPriceList()
}