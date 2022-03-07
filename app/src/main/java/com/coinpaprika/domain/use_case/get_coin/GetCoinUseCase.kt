package com.coinpaprika.domain.use_case.get_coin

import com.coinpaprika.common.Resource
import com.coinpaprika.data.dto.coin_detail.toCoinDetail
import com.coinpaprika.domain.models.CoinDetail
import com.coinpaprika.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Rehan Sarwar on 07/03/2022.
 * Use case should have only one public function to execute the UseCase
 */
class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetail = repository.getCoinDetails(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach the server. Check your internet connection"))
        }
    }
}