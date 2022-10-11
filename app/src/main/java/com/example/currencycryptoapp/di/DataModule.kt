package com.example.currencycryptoapp.di

import android.app.Application
import com.example.currencycryptoapp.data.database.AppDatabase
import com.example.currencycryptoapp.data.database.CoinInfoDao
import com.example.currencycryptoapp.data.network.ApiFactory
import com.example.currencycryptoapp.data.network.ApiService
import com.example.currencycryptoapp.data.repository.CoinRepositoryImpl
import com.example.currencycryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}