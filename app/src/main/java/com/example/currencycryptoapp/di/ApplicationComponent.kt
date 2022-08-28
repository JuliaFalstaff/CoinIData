package com.example.currencycryptoapp.di

import android.app.Application
import com.example.currencycryptoapp.presentation.ui.CoinDetailFragment
import com.example.currencycryptoapp.presentation.ui.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}