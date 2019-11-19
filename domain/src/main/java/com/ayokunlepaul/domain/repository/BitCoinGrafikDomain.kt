package com.ayokunlepaul.domain.repository

import com.ayokunlepaul.domain.models.BitCoinChartValue
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface BitCoinGrafikDomain {

    fun getBitCoinGrafikValueRemote(): Single<List<BitCoinChartValue>>

    fun getBitCoinGrafikValueLocal(): Observable<List<BitCoinChartValue>>
}