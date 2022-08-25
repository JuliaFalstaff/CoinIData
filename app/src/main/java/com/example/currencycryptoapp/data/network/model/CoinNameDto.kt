package com.example.currencycryptoapp.data.network.model

import com.google.gson.annotations.SerializedName


data class CoinNameDto(
    @SerializedName("Name")
    var name: String? = null,
)
