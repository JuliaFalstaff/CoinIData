package com.jfalstaff.currencycryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.jfalstaff.currencycryptoapp.data.database.CoinInfoDao
import com.jfalstaff.currencycryptoapp.data.mapper.CoinMapper
import com.jfalstaff.currencycryptoapp.data.worker.RefreshDataWorker
import com.jfalstaff.currencycryptoapp.domain.CoinInfoEntity
import com.jfalstaff.currencycryptoapp.domain.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val application: Application,
    private val coinInfoDao: CoinInfoDao,
    private val mapper: CoinMapper
) : CoinRepository {

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