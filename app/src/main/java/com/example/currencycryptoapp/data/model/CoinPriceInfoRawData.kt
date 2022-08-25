package com.example.currencycryptoapp.data.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class CoinPriceInfoRawData(
    @SerializedName("RAW")
    val coinPriceInfoJsonObject: JsonObject? = null
)
