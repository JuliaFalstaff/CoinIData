package com.example.currencycryptoapp.data.network.model

import com.google.gson.annotations.SerializedName

data class CoinNamesListDto(
    @SerializedName(ENTITY_COIN_NAMES_DATA)
    val names: List<CoinNameContainerDto>? = null
) {
    companion object {
        const val ENTITY_COIN_NAMES_DATA = "Data"
    }
}
