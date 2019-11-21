package com.ayokunlepaul.repository

import com.ayokunlepaul.repository.models.BitCoinChartValueEntity
import io.reactivex.Single

interface BitCoinGrafikRepository {

    fun getBitCoinValuesRemote(
        statType: String,
        queryMap: HashMap<String, String>
    ): Single<List<BitCoinChartValueEntity>>
}