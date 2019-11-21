package com.ayokunlepaul.domain.repository

import com.ayokunlepaul.domain.models.BitCoinChartValue
import io.reactivex.Single

interface BitCoinGrafikDomain {

    fun getBitCoinGrafikValueRemote(
        statType: String,
        queryMap: HashMap<String, String>
    ): Single<List<BitCoinChartValue>>
}