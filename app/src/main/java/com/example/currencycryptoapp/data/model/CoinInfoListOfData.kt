package com.example.currencycryptoapp.data.model

import com.google.gson.annotations.SerializedName

data class CoinInfoListOfData(
    @SerializedName("Data")
    val data: List<Datum>? = null
)
