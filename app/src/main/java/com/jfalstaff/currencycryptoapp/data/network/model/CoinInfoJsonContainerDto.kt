package com.jfalstaff.currencycryptoapp.data.network.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class CoinInfoJsonContainerDto(
    @SerializedName(ENTITY_RAW_JSON)
    val json: JsonObject? = null
) {
    companion object {
        const val ENTITY_RAW_JSON = "RAW"
    }
}
