package com.example.currencycryptoapp.api

import com.example.currencycryptoapp.BuildConfig
import com.example.currencycryptoapp.data.CoinInfoListOfData
import com.example.currencycryptoapp.data.CoinPriceInfoRawData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_API_KEY) apiKey: String = CRYPTO_API_KEY,
        @Query(QUERY_LIMIT) limit: Int = 15,
        @Query(QUERY_TSYM) tsym: String = CURRENCY

    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_API_KEY) apiKey: String = CRYPTO_API_KEY,
        @Query(QUERY_TSYMS) tsyms: String = CURRENCY,
        @Query(QUERY_FSYMS) fsyms: String,
    ): Single<CoinPriceInfoRawData>

    companion object {
        private const val QUERY_LIMIT = "limit"
        private const val QUERY_TSYM = "tsym"
        private const val QUERY_API_KEY = "api_key"
        private const val CRYPTO_API_KEY = BuildConfig.CRYPTO_COMPARE_API_KEY
        private const val CURRENCY = "USD"
        private const val QUERY_TSYMS = "tsyms"
        private const val QUERY_FSYMS = "fsyms"
    }
}