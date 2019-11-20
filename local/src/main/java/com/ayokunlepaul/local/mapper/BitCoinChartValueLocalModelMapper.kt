package com.ayokunlepaul.local.mapper

import com.ayokunlepaul.local.models.BitCoinChartValueLocalModel
import com.ayokunlepaul.repository.models.BitCoinChartValueEntity
import com.ayokunlepaul.repository.mapper.RepositoryMapper
import javax.inject.Inject

class BitCoinChartValueLocalModelMapper @Inject constructor() : RepositoryMapper<BitCoinChartValueLocalModel, BitCoinChartValueEntity> {

    override fun mapToRepository(from: BitCoinChartValueLocalModel): BitCoinChartValueEntity {
        return BitCoinChartValueEntity(
            xAxis = from.xAxis,
            yAxis = from.yAxis
        )
    }

    override fun mapFromRepository(to: BitCoinChartValueEntity): BitCoinChartValueLocalModel {
        return BitCoinChartValueLocalModel(
            xAxis = to.xAxis,
            yAxis = to.yAxis
        )
    }
}