package com.coinpaprika.presentation.coin_list

import com.coinpaprika.domain.models.Coin

/**
 * Created by Rehan Sarwar on 07/03/2022.
 */
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""

)