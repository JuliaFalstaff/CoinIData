package com.example.currencycryptoapp.data.network.model

import com.google.gson.annotations.SerializedName

data class CoinNameContainerDto(
    @SerializedName(ENTITY_COIN_INFO)
    val coinName: CoinNameDto? = null
) {
    companion object {
        const val ENTITY_COIN_INFO = "CoinInfo"
    }
}
