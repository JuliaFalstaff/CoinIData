package com.example.currencycryptoapp.di

import androidx.work.ListenableWorker
import com.example.currencycryptoapp.data.worker.ChildWorkerFactory
import com.example.currencycryptoapp.data.worker.RefreshDataWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorkerFactory(worker: RefreshDataWorker.Factory): ChildWorkerFactory
}