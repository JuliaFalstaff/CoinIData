package com.jfalstaff.currencycryptoapp.di

import com.jfalstaff.currencycryptoapp.data.worker.ChildWorkerFactory
import com.jfalstaff.currencycryptoapp.data.worker.RefreshDataWorker
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