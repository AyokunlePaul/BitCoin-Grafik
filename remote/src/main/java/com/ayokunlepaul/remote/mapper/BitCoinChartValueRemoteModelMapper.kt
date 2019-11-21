package com.ayokunlepaul.remote.mapper

import com.ayokunlepaul.remote.model.BitCoinChartValueRemoteModel
import com.ayokunlepaul.repository.mapper.RepositoryMapper
import com.ayokunlepaul.repository.models.BitCoinChartValueEntity
import javax.inject.Inject

class BitCoinChartValueRemoteModelMapper @Inject constructor() : RepositoryMapper<BitCoinChartValueRemoteModel, BitCoinChartValueEntity> {

    override fun mapToRepository(from: BitCoinChartValueRemoteModel): BitCoinChartValueEntity {
        return BitCoinChartValueEntity(
            xAxis = from.xAxis,
            yAxis = from.yAxis
        )
    }

    override fun mapFromRepository(to: BitCoinChartValueEntity): BitCoinChartValueRemoteModel {
        throw IllegalStateException("Cannot map to remote from repository")
    }
}