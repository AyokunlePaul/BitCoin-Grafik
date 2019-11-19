package com.ayokunlepaul.repository.impl

import com.ayokunlepaul.domain.models.BitCoinChartValue
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.repository.BlockchainGrafikRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class BlockchainRepositoryImpl @Inject constructor(
    @Named("LOCAL") private val local: BlockchainGrafikRepository,
    @Named("REMOTE") private val remote: BlockchainGrafikRepository
) : BitCoinGrafikDomain {

    override fun getBitCoinGrafikValueRemote(): Completable {
        return remote.getBitCoinValuesRemote().flatMapCompletable {
            local.saveBitCoinValues(it)
            Completable.complete()
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