package com.example.currencycryptoapp.domain

class LoadDataUseCase(private val repository: CoinRepository) {
    operator fun invoke() = repository.loadData()
}