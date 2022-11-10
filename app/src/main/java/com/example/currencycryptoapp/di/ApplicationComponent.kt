package com.example.currencycryptoapp.di

import android.app.Application
import com.example.currencycryptoapp.CryptoApp
import com.example.currencycryptoapp.presentation.ui.CoinDetailFragment
import com.example.currencycryptoapp.presentation.ui.CoinPriceListActivity
import com.example.currencycryptoapp.presentation.ui.CoinPriceListFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        WorkerModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)

    fun inject(application: CryptoApp)

    fun inject(fragment: CoinPriceListFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}