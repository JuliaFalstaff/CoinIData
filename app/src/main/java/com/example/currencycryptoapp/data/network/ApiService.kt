package com.example.currencycryptoapp.data.network

import com.example.currencycryptoapp.BuildConfig
import com.example.currencycryptoapp.data.network.model.CoinNamesListDto
import com.example.currencycryptoapp.data.network.model.CoinInfoJsonContainerDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top/totalvolfull")
    suspend fun getTopCoinsInfo(
        @Query(QUERY_API_KEY) apiKey: String = CRYPTO_API_KEY,
        @Query(QUERY_LIMIT) limit: Int,
        @Query(QUERY_TSYM) tsym: String = CURRENCY
    ): CoinNamesListDto

    @GET("pricemultifull")
    suspend fun getFullPriceList(
        @Query(QUERY_API_KEY) apiKey: String = CRYPTO_API_KEY,
        @Query(QUERY_TSYMS) tsyms: String = CURRENCY,
        @Query(QUERY_FSYMS) fsyms: String,
    ): CoinInfoJsonContainerDto

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