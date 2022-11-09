package com.example.currencycryptoapp.data.network.model

import com.google.gson.annotations.SerializedName

data class CoinNameDto(
    @SerializedName(ENTITY_COIN_NAME)
    var name: String? = null,
) {
    companion object {
        const val ENTITY_COIN_NAME = "Name"
    }
}
