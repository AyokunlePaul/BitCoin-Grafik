package com.ayokunlepaul.repository.impl

import com.ayokunlepaul.domain.models.BitCoinChartValue
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.repository.BitCoinGrafikRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class BitCoinRepositoryImpl @Inject constructor(
    @Named("REMOTE") private val remote: BitCoinGrafikRepository
) : BitCoinGrafikDomain {

    override fun getBitCoinGrafikValueRemote(
        statType: String,
        queryMap: HashMap<String, String>
    ): Single<List<BitCoinChartValue>> {
        return remote.getBitCoinValuesRemote(statType, queryMap).map { bitCoinChartEntities ->
            bitCoinChartEntities.map {
                BitCoinChartValue(
                    xAxis = it.xAxis,
                    yAxis = it.yAxis
                )
            }
        }
    }
}