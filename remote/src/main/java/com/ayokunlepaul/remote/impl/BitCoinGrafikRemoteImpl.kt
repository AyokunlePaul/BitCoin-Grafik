package com.ayokunlepaul.remote.impl

import com.ayokunlepaul.remote.mapper.BitCoinChartValueRemoteModelMapper
import com.ayokunlepaul.remote.services.BitCoinGrafikChartService
import com.ayokunlepaul.remote.utils.doOnError
import com.ayokunlepaul.repository.BitCoinGrafikRepository
import com.ayokunlepaul.repository.models.BitCoinChartValueEntity
import io.reactivex.Single
import javax.inject.Inject

class BitCoinGrafikRemoteImpl @Inject constructor(
    private val service: BitCoinGrafikChartService,
    private val mapper: BitCoinChartValueRemoteModelMapper
) : BitCoinGrafikRepository {

    override fun getBitCoinValuesRemote(
        statType: String,
        queryMap: HashMap<String, String>
    ): Single<List<BitCoinChartValueEntity>> {
        return service.getCharts(statType, queryMap).doOnError().map {
            it.data.map { bitcoinGrafikChartValueRemote ->
                mapper.mapToRepository(bitcoinGrafikChartValueRemote)
            }
        }
    }
}