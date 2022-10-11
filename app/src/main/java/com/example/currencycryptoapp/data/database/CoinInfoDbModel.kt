package com.example.currencycryptoapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinInfoDbModel(
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    val fromSymbol: String,
    @SerializedName("TOSYMBOL")
    val toSymbol: String?,
    @SerializedName("PRICE")
    val price: String?,
    @SerializedName("LASTUPDATE")
    val lastUpdate: Long?,
    @SerializedName("HIGHDAY")
    val highDay: String?,
    @SerializedName("LOWDAY")
    val lowDay: String?,
    @SerializedName("LASTMARKET")
    val lastMarket: String?,
    @SerializedName("IMAGEURL")
    val imageUrl: String
)