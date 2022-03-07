package com.coinpaprika.domain.repository

import com.coinpaprika.data.dto.CoinDto
import com.coinpaprika.data.dto.coin_detail.CoinDetailDto

/**
 * Created by Rehan Sarwar on 07/03/2022.
 * In Domain Layer we have only Definition not implementation
 * */

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinDetails(coinId: String): CoinDetailDto
}