package com.example.currencycryptoapp.data.model

import com.google.gson.annotations.SerializedName


data class CoinInfo(
    @SerializedName("Name")
    var name: String? = null,
)
