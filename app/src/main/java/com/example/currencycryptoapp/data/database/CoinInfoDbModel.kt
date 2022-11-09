package com.example.currencycryptoapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.currencycryptoapp.data.database.CoinInfoDbModel.Companion.TABLE_FULL_PRICE_LIST
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_FULL_PRICE_LIST)
data class CoinInfoDbModel(
    @PrimaryKey
    @SerializedName(DB_MODEL_FROM_SYMBOL)
    val fromSymbol: String,
    @SerializedName(DB_MODEL_TO_SYMBOL)
    val toSymbol: String?,
    @SerializedName(DB_MODEL_PRICE)
    val price: String?,
    @SerializedName(DB_MODEL_LAST_UPDATE)
    val lastUpdate: Long?,
    @SerializedName(DB_MODEL_HIGH_DAY)
    val highDay: String?,
    @SerializedName(DB_MODEL_LOW_DAY)
    val lowDay: String?,
    @SerializedName(DB_MODEL_LAST_MARKET)
    val lastMarket: String?,
    @SerializedName(DB_MODEL_IMAGE_URL)
    val imageUrl: String,
    @SerializedName(DB_MODEL_CHANGE_24_HOUR)
    val change24Hour: String?,
    @SerializedName(DB_MODEL_OPEN_24_HOUR)
    val open24Hour: String?,
    @SerializedName(DB_MODEL_HIGH_24_HOUR)
    val high24Hour: String?,
    @SerializedName(DB_MODEL_LOW_24_HOUR)
    val low24Hour: String?,
) {
    companion object {
       const val TABLE_FULL_PRICE_LIST = "full_price_list"
       const val DB_MODEL_FROM_SYMBOL = "FROMSYMBOL"
       const val DB_MODEL_TO_SYMBOL = "TOSYMBOL"
       const val DB_MODEL_PRICE = "PRICE"
       const val DB_MODEL_LAST_UPDATE = "LASTUPDATE"
       const val DB_MODEL_HIGH_DAY = "HIGHDAY"
       const val DB_MODEL_LOW_DAY = "LOWDAY"
       const val DB_MODEL_LAST_MARKET = "LASTMARKET"
       const val DB_MODEL_IMAGE_URL = "IMAGEURL"
       const val DB_MODEL_CHANGE_24_HOUR = "CHANGE24HOUR"
       const val DB_MODEL_OPEN_24_HOUR = "OPEN24HOUR"
       const val DB_MODEL_HIGH_24_HOUR = "HIGH24HOUR"
       const val DB_MODEL_LOW_24_HOUR = "LOW24HOUR"
    }
}