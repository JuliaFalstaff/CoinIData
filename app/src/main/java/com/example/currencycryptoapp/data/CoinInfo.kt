package com.example.currencycryptoapp.data

import com.google.gson.annotations.SerializedName


data class CoinInfo(
    @SerializedName("Id")
    var id: String? = null,
    @SerializedName("Name")
    var name: String? = null,
    @SerializedName("FullName")
    var fullName: String? = null,
    @SerializedName("ImageUrl")
    var imageUrl: String? = null
)
