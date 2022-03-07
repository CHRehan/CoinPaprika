package com.coinpaprika.domain.use_case.get_coins

import com.coinpaprika.common.Resource
import com.coinpaprika.data.dto.toCoin
import com.coinpaprika.domain.models.Coin
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
class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins()
            emit(Resource.Success<List<Coin>>(coins.map { coinDto -> coinDto.toCoin() }))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach the server. Check your internet connection"))
        }
    }
}