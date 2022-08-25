package com.example.currencycryptoapp.data.worker

import android.content.Context
import androidx.work.*
import com.example.currencycryptoapp.data.database.AppDatabase
import com.example.currencycryptoapp.data.mapper.CoinMapper
import com.example.currencycryptoapp.data.network.ApiFactory
import kotlinx.coroutines.delay

class RefreshDataWorker(context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {

    private val coinInfoDao = AppDatabase.getInstance(context).coinPriceInfoDao()
    private val mapper = CoinMapper()
    private val apiService = ApiFactory.apiService

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 50)
                val fSym = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fsyms = fSym)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDTOtoDbModel(it) }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
            }
            delay(10000)
        }
    }

    companion object {
        const val WORKER_NAME = "refresh_data_worker"
        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }
    }
}