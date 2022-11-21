package com.jfalstaff.currencycryptoapp.di

import android.app.Application
import com.jfalstaff.currencycryptoapp.data.database.AppDatabase
import com.jfalstaff.currencycryptoapp.data.database.CoinInfoDao
import com.jfalstaff.currencycryptoapp.data.network.ApiFactory
import com.jfalstaff.currencycryptoapp.data.network.ApiService
import com.jfalstaff.currencycryptoapp.data.repository.CoinRepositoryImpl
import com.jfalstaff.currencycryptoapp.domain.CoinRepository
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