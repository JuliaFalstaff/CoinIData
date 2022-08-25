package com.example.currencycryptoapp.domain

class GetCoinInfoDetailsUseCase(private val repository: CoinRepository) {

    operator fun invoke(fromSymbol: String) = repository.getCoinInfoDetails(fromSymbol)
}