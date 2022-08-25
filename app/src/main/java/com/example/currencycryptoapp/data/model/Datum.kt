package com.example.currencycryptoapp.data.model

import com.google.gson.annotations.SerializedName

data class Datum(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfo? = null
)
