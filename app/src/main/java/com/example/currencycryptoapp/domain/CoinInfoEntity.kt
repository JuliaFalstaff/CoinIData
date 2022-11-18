package com.example.currencycryptoapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinInfoEntity(
    val fromSymbol: String,
    val toSymbol: String?,
    val price: String?,
    val lastUpdate: String,
    val highDay: String?,
    val lowDay: String?,
    val lastMarket: String?,
    val imageUrl: String,
    val change24Hour: String?,
    val high24Hour: String?,
    val low24Hour: String?,
    val open24Hour: String?
): Parcelable