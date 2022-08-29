package com.example.currencycryptoapp.data.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.currencycryptoapp.data.database.CoinInfoDao
import com.example.currencycryptoapp.data.mapper.CoinMapper
import com.example.currencycryptoapp.data.network.ApiService
import javax.inject.Inject

class RefreshDataWorkerFactory @Inject constructor(
    private val coinInfoDao: CoinInfoDao,
    private val mapper: CoinMapper,
    private val apiService: ApiService
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return RefreshDataWorker(
            appContext, workerParameters,
            coinInfoDao, mapper, apiService
        )
    }
}