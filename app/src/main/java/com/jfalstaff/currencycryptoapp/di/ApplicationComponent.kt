package com.jfalstaff.currencycryptoapp.di

import android.app.Application
import com.jfalstaff.currencycryptoapp.CryptoApp
import com.jfalstaff.currencycryptoapp.presentation.ui.CoinDetailFragment
import com.jfalstaff.currencycryptoapp.presentation.ui.CoinPriceListActivity
import com.jfalstaff.currencycryptoapp.presentation.ui.CoinPriceListFragment
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