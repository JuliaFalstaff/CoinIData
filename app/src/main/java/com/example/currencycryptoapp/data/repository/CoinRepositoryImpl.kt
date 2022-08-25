package com.example.currencycryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.currencycryptoapp.data.database.AppDatabase
import com.example.currencycryptoapp.data.mapper.CoinMapper
import com.example.currencycryptoapp.data.network.ApiFactory
import com.example.currencycryptoapp.data.network.ApiService
import com.example.currencycryptoapp.data.worker.RefreshDataWorker
import com.example.currencycryptoapp.domain.CoinInfoEntity
import com.example.currencycryptoapp.domain.CoinRepository
import kotlinx.coroutines.delay

class CoinRepositoryImpl(private val application: Application): CoinRepository {
    private val coinInfoDao = AppDatabase.getInstance(application).coinPriceInfoDao()
    private val mapper = CoinMapper()

    override fun getPriceList(): LiveData<List<CoinInfoEntity>> {
        return Transformations.map(coinInfoDao.getPriceList()) {
           it.map {
               mapper.mapDbModelTOEntity(it)
           }
        }
    }

    override fun getCoinInfoDetails(fSym: String): LiveData<CoinInfoEntity> {
        return Transformations.map(coinInfoDao.getPriceInfoAboutCoin(fSym)) {
            mapper.mapDbModelTOEntity(it)
        }
    }

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}