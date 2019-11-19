package com.ayokunlepaul.remote.impl

import com.ayokunlepaul.remote.services.BitcoinGrafikService
import com.ayokunlepaul.remote.mapper.BlockchainChartValueRemoteModelMapper
import com.ayokunlepaul.remote.utils.doOnError
import com.ayokunlepaul.repository.BlockchainGrafikRepository
import com.ayokunlepaul.repository.models.BitCoinChartValueEntity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class BlockchainRemoteImpl @Inject constructor(
    private val service: BitcoinGrafikService,
    private val mapper: BlockchainChartValueRemoteModelMapper
) : BlockchainGrafikRepository {

    override fun getBitCoinValuesRemote(): Single<List<BitCoinChartValueEntity>> {
        return service.getCharts("market-price").doOnError().observeOn(AndroidSchedulers.mainThread()).map {
            it.data.map { bitcoinGrafikChartValueRemote ->
                mapper.mapToRepository(bitcoinGrafikChartValueRemote)
            }
        }
    }

    override fun saveBitCoinValues(value: List<BitCoinChartValueEntity>) {
        throw IllegalStateException ("Implementation doesn't exist in this module")
    }

    override fun getBitCoinValuesLocal(): Observable<List<BitCoinChartValueEntity>> {
        throw IllegalStateException("Implementation doesn't exist in this module")
    }

    override val localValueSize: Int
        get() = throw IllegalStateException("Implementation doesn't exist in this module")
}