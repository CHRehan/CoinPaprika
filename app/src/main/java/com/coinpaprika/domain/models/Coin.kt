package com.coinpaprika.domain.models

/**
 * Created by Rehan Sarwar on 07/03/2022.
 */
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)