package com.coinpaprika.di

import com.coinpaprika.common.Constants
import com.coinpaprika.data.remote.CoinPaprikaApi
import com.coinpaprika.data.repository.CoinRepositoryImp
import com.coinpaprika.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Rehan Sarwar on 07/03/2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun providePaprikaRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImp(api)
    }
}