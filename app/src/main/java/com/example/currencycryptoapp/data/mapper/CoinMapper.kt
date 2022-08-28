package com.example.currencycryptoapp.data.mapper

import com.example.currencycryptoapp.data.database.CoinInfoDbModel
import com.example.currencycryptoapp.data.network.model.CoinInfoDto
import com.example.currencycryptoapp.data.network.model.CoinInfoJsonContainerDto
import com.example.currencycryptoapp.data.network.model.CoinNamesListDto
import com.example.currencycryptoapp.domain.CoinInfoEntity
import com.google.gson.Gson
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CoinMapper @Inject constructor() {
    fun mapDTOtoDbModel(dto: CoinInfoDto):  CoinInfoDbModel = CoinInfoDbModel(
        dto.fromSymbol,
        dto.toSymbol,
        dto.price,
        dto.lastUpdate,
        dto.highDay,
        dto.lowDay,
        dto.lastMarket,
        BASE_IMAGE_URL + dto.imageUrl
    )

    fun mapJsonContainerToListCoinInfo(jsonContainer: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = jsonContainer.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currentKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(currencyJson.getAsJsonObject(currentKey), CoinInfoDto::class.java)
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesListDto: CoinNamesListDto): String {
        return namesListDto.names?.map {
            it.coinName?.name
        }?.joinToString(",") ?: ""
    }

    fun mapDbModelTOEntity(dbModel: CoinInfoDbModel): CoinInfoEntity {
        return CoinInfoEntity(
            dbModel.fromSymbol,
            dbModel.toSymbol,
            dbModel.price,
            convertTimestampToTime(dbModel.lastUpdate),
            dbModel.highDay,
            dbModel.lowDay,
            dbModel.lastMarket,
            dbModel.imageUrl
        )
    }

   private fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stampInMillis = Timestamp(timestamp * 1000)
        val date = Date(stampInMillis.time)
        val pattern = "HH:mm:ss"
        val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
        simpleDateFormat.timeZone = TimeZone.getDefault()
        return simpleDateFormat.format(date)
    }

    companion object {
        const val BASE_IMAGE_URL = "https://cryptocompare.com"
    }
}