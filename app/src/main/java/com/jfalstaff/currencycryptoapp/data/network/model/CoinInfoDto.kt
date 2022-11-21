package com.jfalstaff.currencycryptoapp.data.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinInfoDto(
    @SerializedName(ENTITY_TYPE)
    @Expose
    val type: String?,
    @SerializedName(ENTITY_MARKET)
    @Expose
    val market: String?,
    @PrimaryKey
    @SerializedName(ENTITY_FROM_SYMBOL)
    @Expose
    val fromSymbol: String,
    @SerializedName(ENTITY_TO_SYMBOL)
    @Expose
    val toSymbol: String?,
    @SerializedName(ENTITY_FLAGS)
    @Expose
    val flags: String?,
    @SerializedName(ENTITY_PRICE)
    @Expose
    val price: String?,
    @SerializedName(ENTITY_LAST_UPDATE)
    @Expose
    val lastUpdate: Long?,
    @SerializedName(ENTITY_LAST_VOLUME)
    @Expose
    val lastVolume: String?,
    @SerializedName(ENTITY_LAST_VOLUME_TO)
    @Expose
    val lastVolumeTo: String?,
    @SerializedName(ENTITY_LAST_TRADE_ID)
    @Expose
    val lastTradeId: String?,
    @SerializedName(ENTITY_VOLUME_DAY)
    @Expose
    val volumeDay: String?,
    @SerializedName(ENTITY_VOLUME_DAY_TO)
    @Expose
    val volumeDayTo: String?,
    @SerializedName(ENTITY_VOLUME_24_HOUR)
    @Expose
    val volume24Hour: String?,
    @SerializedName(ENTITY_VOLUME_24_HOUR_TO)
    @Expose
    val volume24HourTo: String?,
    @SerializedName(ENTITY_OPEN_DAY)
    @Expose
    val openDay: String?,
    @SerializedName(ENTITY_HIGH_DAY)
    @Expose
    val highDay: String?,
    @SerializedName(ENTITY_LOW_DAY)
    @Expose
    val lowDay: String?,
    @SerializedName(ENTITY_OPEN24HOUR)
    @Expose
    val open24Hour: String?,
    @SerializedName(ENTITY_HIGH24HOUR)
    @Expose
    val high24Hour: String?,
    @SerializedName(ENTITY_LOW24HOUR)
    @Expose
    val low24Hour: String?,
    @SerializedName(ENTITY_LAST_MARKET)
    @Expose
    val lastMarket: String?,
    @SerializedName(ENTITY_VOLUME_HOUR)
    @Expose
    val volumeHour: String?,
    @SerializedName(ENTITY_VOLUME_HOUR_TO)
    @Expose
    val volumeHourTo: String?,
    @SerializedName(ENTITY_OPEN_HOUR)
    @Expose
    val openHour: String?,
    @SerializedName(ENTITY_HIGH_HOUR)
    @Expose
    val highHour: String?,
    @SerializedName(ENTITY_LOW_HOUR)
    @Expose
    val lowHour: String?,
    @SerializedName(ENTITY_TOP_TIER_VOLUME_24_HOUR)
    @Expose
    val topTierVolume24Hour: String?,
    @SerializedName(ENTITY_TOP_TIER_VOLUME_24_HOUR_TO)
    @Expose
    val topTierVolume24HourTo: String?,
    @SerializedName(ENTITY_CHANGE_24_HOUR)
    @Expose
    val change24Hour: String?,
    @SerializedName(ENTITY_CHANGE_PCT_24_HOUR)
    @Expose
    val changePCT24Hour: String?,
    @SerializedName(ENTITY_CHANGE_DAY)
    @Expose
    val changeDay: String?,
    @SerializedName(ENTITY_CHANGE_PCT_DAY)
    @Expose
    val changePCTDay: String?,
    @SerializedName(ENTITY_SUPPLY)
    @Expose
    val supply: String?,
    @SerializedName(ENTITY_MKTCAP)
    @Expose
    val mktCap: String?,
    @SerializedName(ENTITY_TOTAL_VOLUME_24H)
    @Expose
    val totalVolume24Hour: String?,
    @SerializedName(ENTITY_TOTAL_VOLUME24HTO)
    @Expose
    val totalVolume24HourTo: String?,
    @SerializedName(ENTITY_TOTAL_TOP_TIER_VOLUME_24H)
    @Expose
    val totalTopTierVolume24Hour: String?,
    @SerializedName(ENTITY_TOTAL_TOP_TIER_VOLUME_24H_TO)
    @Expose
    val totalTopTierVolume24HourTo: String?,
    @SerializedName(ENTITY_IMAGE_URL)
    @Expose
    val imageUrl: String?
) {
    companion object {
        const val ENTITY_TYPE = "TYPE"
        const val ENTITY_MARKET = "MARKET"
        const val ENTITY_FROM_SYMBOL = "FROMSYMBOL"
        const val ENTITY_TO_SYMBOL = "TOSYMBOL"
        const val ENTITY_FLAGS = "FLAGS"
        const val ENTITY_PRICE = "PRICE"
        const val ENTITY_LAST_UPDATE = "LASTUPDATE"
        const val ENTITY_LAST_VOLUME = "LASTVOLUME"
        const val ENTITY_LAST_VOLUME_TO = "LASTVOLUMETO"
        const val ENTITY_LAST_TRADE_ID = "LASTTRADEID"
        const val ENTITY_VOLUME_DAY = "VOLUMEDAY"
        const val ENTITY_VOLUME_DAY_TO = "VOLUMEDAYTO"
        const val ENTITY_VOLUME_24_HOUR = "VOLUME24HOUR"
        const val ENTITY_VOLUME_24_HOUR_TO = "VOLUME24HOURTO"
        const val ENTITY_OPEN_DAY = "OPENDAY"
        const val ENTITY_HIGH_DAY = "HIGHDAY"
        const val ENTITY_LOW_DAY = "LOWDAY"
        const val ENTITY_OPEN24HOUR = "OPEN24HOUR"
        const val ENTITY_HIGH24HOUR = "HIGH24HOUR"
        const val ENTITY_LOW24HOUR = "LOW24HOUR"
        const val ENTITY_LAST_MARKET = "LASTMARKET"
        const val ENTITY_VOLUME_HOUR = "VOLUMEHOUR"
        const val ENTITY_VOLUME_HOUR_TO = "VOLUMEHOURTO"
        const val ENTITY_OPEN_HOUR = "OPENHOUR"
        const val ENTITY_HIGH_HOUR = "HIGHHOUR"
        const val ENTITY_LOW_HOUR = "LOWHOUR"
        const val ENTITY_TOP_TIER_VOLUME_24_HOUR = "TOPTIERVOLUME24HOUR"
        const val ENTITY_TOP_TIER_VOLUME_24_HOUR_TO = "TOPTIERVOLUME24HOURTO"
        const val ENTITY_CHANGE_24_HOUR = "CHANGE24HOUR"
        const val ENTITY_CHANGE_PCT_24_HOUR = "CHANGEPCT24HOUR"
        const val ENTITY_CHANGE_DAY = "CHANGEDAY"
        const val ENTITY_CHANGE_PCT_DAY = "CHANGEPCTDAY"
        const val ENTITY_SUPPLY = "SUPPLY"
        const val ENTITY_MKTCAP = "MKTCAP"
        const val ENTITY_TOTAL_VOLUME_24H = "TOTALVOLUME24H"
        const val ENTITY_TOTAL_VOLUME24HTO = "TOTALVOLUME24HTO"
        const val ENTITY_TOTAL_TOP_TIER_VOLUME_24H = "TOTALTOPTIERVOLUME24H"
        const val ENTITY_TOTAL_TOP_TIER_VOLUME_24H_TO = "TOTALTOPTIERVOLUME24HTO"
        const val ENTITY_IMAGE_URL = "IMAGEURL"
    }
}