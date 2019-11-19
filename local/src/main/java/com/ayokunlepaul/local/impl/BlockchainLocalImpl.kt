package com.ayokunlepaul.local.impl

import com.ayokunlepaul.local.mapper.BlockchainChartValueLocalModelMapper
import com.ayokunlepaul.local.room.dao.BitCoinValueDao
import com.ayokunlepaul.repository.models.BitCoinChartValueEntity
import com.ayokunlepaul.repository.BitCoinGrafikRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class BlockchainLocalImpl @Inject constructor(
    private val blockchainValueDao: BitCoinValueDao,
    private val mapper: BlockchainChartValueLocalModelMapper
) : BitCoinGrafikRepository {

    override fun getBitCoinValuesRemote(): Single<List<BitCoinChartValueEntity>> {
        throw IllegalStateException("Implementation doesn't exist in this module")
    }

    override fun saveBitCoinValues(value: List<BitCoinChartValueEntity>) {
        blockchainValueDao.saveBitCoinValues(
            mapper.mapFromRepositoryList(value)
        )
    }

    override fun getBitCoinValuesLocal(): Observable<List<BitCoinChartValueEntity>> {
        return blockchainValueDao.observeBitCoinValueTable().map {
            mapper.mapToRepositoryList(it)
        }
    }

    override val localValueSize: Int
        get() = blockchainValueDao.getBitCoinValueTableSize()
}