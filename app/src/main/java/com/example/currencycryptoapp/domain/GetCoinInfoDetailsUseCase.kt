package com.example.currencycryptoapp.domain

import javax.inject.Inject

class GetCoinInfoDetailsUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(fromSymbol: String) = repository.getCoinInfoDetails(fromSymbol)
}