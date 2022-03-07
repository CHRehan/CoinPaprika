package com.coinpaprika.domain.models

import com.coinpaprika.data.dto.coin_detail.TeamMember

/**
 * Created by Rehan Sarwar on 07/03/2022.
 */
data class CoinDetail(
    val coinId:String,
    val name:String,
    val description:String,
    val symbol:String,
    val rank:Int,
    val isActive:Boolean,
    val tags:List<String>,
    val teams:List<TeamMember>

)
