package com.ayokunlepaul.remote.mapper

import com.ayokunlepaul.remote.model.BlockchainChartValueRemoteModel
import com.ayokunlepaul.repository.models.BitCoinChartValueEntity
import com.ayokunlepaul.repository.mapper.RepositoryMapper
import javax.inject.Inject

class BlockchainChartValueRemoteModelMapper @Inject constructor(

): RepositoryMapper<BlockchainChartValueRemoteModel, BitCoinChartValueEntity> {

    override fun mapToRepository(from: BlockchainChartValueRemoteModel): BitCoinChartValueEntity {
        return BitCoinChartValueEntity(
            xAxis = from.xAxis,
            yAxis = from.yAxis
        )
    }

    override fun mapFromRepository(to: BitCoinChartValueEntity): BlockchainChartValueRemoteModel {
        throw IllegalStateException("Cannot map to remote from repository")
    }
}