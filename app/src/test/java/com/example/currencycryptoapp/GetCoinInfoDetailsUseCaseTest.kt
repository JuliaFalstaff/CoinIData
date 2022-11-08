package com.example.currencycryptoapp

import com.example.currencycryptoapp.domain.CoinRepository
import com.example.currencycryptoapp.domain.GetCoinInfoDetailsUseCase
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetCoinInfoDetailsUseCaseTest {

    @Mock
    lateinit var repository: CoinRepository
    lateinit var getCoinInfoDetailsUseCase: GetCoinInfoDetailsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getCoinInfoDetailsUseCase = GetCoinInfoDetailsUseCase(repository)
    }

    @Test
    fun invokeTimes() {
        val symbol = "BTC"
        getCoinInfoDetailsUseCase.invoke(symbol)
        Mockito.verify(repository, Mockito.times(1)).getCoinInfoDetails(symbol)
    }

    @Test
    fun invoke() {
        val symbol = "BTC"
        Mockito.`when`(getCoinInfoDetailsUseCase.invoke(symbol)).then {
            repository.getCoinInfoDetails(symbol)
        }
    }
}