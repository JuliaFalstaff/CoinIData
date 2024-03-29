package com.jfalstaff.currencycryptoapp.di

import androidx.lifecycle.ViewModel
import com.jfalstaff.currencycryptoapp.presentation.ui.CoinViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinViewModel::class)
    fun bindCoinViewModel(viewModel: CoinViewModel): ViewModel
}