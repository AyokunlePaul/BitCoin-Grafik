package com.ayokunlepaul.repository.impl

import com.ayokunlepaul.domain.models.BitCoinChartValue
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.repository.BitCoinGrafikRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class BitCoinRepositoryImpl @Inject constructor(
    @Named("LOCAL") private val local: BitCoinGrafikRepository,
    @Named("REMOTE") private val remote: BitCoinGrafikRepository
) : BitCoinGrafikDomain {

    override fun getBitCoinGrafikValueRemote(): Single<List<BitCoinChartValue>> {
        return remote.getBitCoinValuesRemote().map { bitCoinChartEntities ->
            local.saveBitCoinValues(bitCoinChartEntities)
            bitCoinChartEntities.map {
                BitCoinChartValue(
                    xAxis = it.xAxis,
                    yAxis = it.yAxis
                )
            }
        }
    }

    override fun getBitCoinGrafikValueLocal(): Observable<List<BitCoinChartValue>> {
        return local.getBitCoinValuesLocal().map { entities ->
            entities.map {
                BitCoinChartValue(
                    xAxis = it.xAxis,
                    yAxis = it.yAxis
                )
            }
        }
    }
}