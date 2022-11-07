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
    val imageUrl: String,
    @SerializedName("CHANGE24HOUR")
    val change24Hour: String?,
    @SerializedName("OPEN24HOUR")
    val open24Hour: String?,
    @SerializedName("HIGH24HOUR")
    val high24Hour: String?,
    @SerializedName("LOW24HOUR")
    val low24Hour: String?,
)