package com.coinpaprika.presentation.coin_detail

import com.coinpaprika.domain.models.CoinDetail


data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
