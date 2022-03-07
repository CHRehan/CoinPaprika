package com.coinpaprika.data.remote

import com.coinpaprika.data.dto.CoinDto
import com.coinpaprika.data.dto.coin_detail.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Rehan Sarwar on 07/03/2022.
 */
interface CoinPaprikaApi {

    @GET("v1/coins")
    suspend fun getCoins(): List< CoinDto>


    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String):CoinDetailDto
}
