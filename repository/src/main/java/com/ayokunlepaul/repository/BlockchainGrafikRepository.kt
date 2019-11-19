package com.ayokunlepaul.repository

import com.ayokunlepaul.repository.models.BitCoinChartValueEntity
import io.reactivex.Observable
import io.reactivex.Single

interface BlockchainGrafikRepository {

    fun getBitCoinValuesRemote(): Single<List<BitCoinChartValueEntity>>

    fun getBitCoinValuesLocal(): Observable<List<BitCoinChartValueEntity>>

    fun saveBitCoinValues(value: List<BitCoinChartValueEntity>)

    val localValueSize: Int
}