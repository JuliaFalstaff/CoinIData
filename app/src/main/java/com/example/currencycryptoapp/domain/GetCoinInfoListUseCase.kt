package com.example.currencycryptoapp.domain

class GetCoinInfoListUseCase(private val repository: CoinRepository) {

    operator fun invoke() = repository.getPriceList()
}