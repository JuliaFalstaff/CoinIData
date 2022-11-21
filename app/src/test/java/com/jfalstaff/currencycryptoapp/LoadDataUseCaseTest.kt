package com.jfalstaff.currencycryptoapp

import com.jfalstaff.currencycryptoapp.domain.CoinRepository
import com.jfalstaff.currencycryptoapp.domain.LoadDataUseCase
import com.nhaarman.mockito_kotlin.atLeastOnce
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LoadDataUseCaseTest {

    @Mock
    private lateinit var repository: CoinRepository
    lateinit var loadDataUseCase: LoadDataUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        loadDataUseCase = LoadDataUseCase(repository)
    }

    @Test
    fun invoke() {
        Mockito.`when`(loadDataUseCase.invoke()).then { repository.loadData() }
    }

    @Test
    fun invokeTimes() {
        repository.loadData()
        Mockito.verify(repository, atLeastOnce()).loadData()
    }
}