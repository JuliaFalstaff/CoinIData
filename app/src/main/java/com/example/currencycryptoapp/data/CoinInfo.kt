package com.example.currencycryptoapp.data

import com.google.gson.annotations.SerializedName


data class CoinInfo(
    @SerializedName("Name")
    var name: String? = null,
)
