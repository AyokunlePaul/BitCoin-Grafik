package com.ayokunlepaul.remote.impl

import com.ayokunlepaul.remote.mapper.BlockchainChartValueRemoteModelMapper
import com.ayokunlepaul.remote.services.BitcoinGrafikService
import com.ayokunlepaul.remote.utils.doOnError
import com.ayokunlepaul.repository.BitCoinGrafikRepository
import com.ayokunlepaul.repository.models.BitCoinChartValueEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class BitCoinGrafikRemoteImpl @Inject constructor(
    private val service: BitcoinGrafikService,
    private val mapper: BlockchainChartValueRemoteModelMapper
) : BitCoinGrafikRepository {

    override fun getBitCoinValuesRemote(
        statType: String,
        queryMap: HashMap<String, String>
    ): Single<List<BitCoinChartValueEntity>> {
        return service.getCharts(statType, queryMap).doOnError().observeOn(AndroidSchedulers.mainThread()).map {
            it.data.map { bitcoinGrafikChartValueRemote ->
                mapper.mapToRepository(bitcoinGrafikChartValueRemote)
            }
        }
    }
}