package com.jfalstaff.currencycryptoapp

import com.jfalstaff.currencycryptoapp.domain.CoinRepository
import com.jfalstaff.currencycryptoapp.domain.GetCoinInfoDetailsUseCase
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
        getCoinInfoDetailsUseCase.invoke(TEST_SYMBOL)
        Mockito.verify(repository, Mockito.times(1)).getCoinInfoDetails(TEST_SYMBOL)
    }

    @Test
    fun invoke() {
        Mockito.`when`(getCoinInfoDetailsUseCase.invoke(TEST_SYMBOL)).then {
            repository.getCoinInfoDetails(TEST_SYMBOL)
        }
    }

    companion object {
        private const val TEST_SYMBOL = "BTC"
    }
}