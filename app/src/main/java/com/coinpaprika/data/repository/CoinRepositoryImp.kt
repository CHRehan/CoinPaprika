package com.coinpaprika.data.repository

import com.coinpaprika.data.dto.CoinDto
import com.coinpaprika.data.dto.coin_detail.CoinDetailDto
import com.coinpaprika.data.remote.CoinPaprikaApi
import com.coinpaprika.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * Created by Rehan Sarwar on 07/03/2022.
 */
class CoinRepositoryImp @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinDetails(coinId: String): CoinDetailDto {

        return api.getCoinById(coinId = coinId)
    }
}