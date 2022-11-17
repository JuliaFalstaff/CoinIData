package com.example.currencycryptoapp

import com.example.currencycryptoapp.domain.CoinRepository
import com.example.currencycryptoapp.domain.GetCoinInfoListUseCase
import com.nhaarman.mockito_kotlin.atLeastOnce
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetCoinInfoListUseCaseTest {
    @Mock
    lateinit var repository: CoinRepository
    private lateinit var getCoinInfoListUseCase: GetCoinInfoListUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    }

    @Test
    fun invoke() {
        Mockito.`when`(getCoinInfoListUseCase.invoke()).then { repository.getPriceList() }
    }

    @Test
    fun invokeTimes() {
        repository.getPriceList()
        Mockito.verify(repository, atLeastOnce()).getPriceList()
    }
}