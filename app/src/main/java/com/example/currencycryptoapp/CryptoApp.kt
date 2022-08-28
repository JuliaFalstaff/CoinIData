package com.example.currencycryptoapp

import android.app.Application
import com.example.currencycryptoapp.di.DaggerApplicationComponent

class CryptoApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}