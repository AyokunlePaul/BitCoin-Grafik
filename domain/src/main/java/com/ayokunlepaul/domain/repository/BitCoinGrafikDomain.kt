package com.ayokunlepaul.domain.repository

import com.ayokunlepaul.domain.models.BitCoinChartValue
import io.reactivex.Completable
import io.reactivex.Observable

interface BitCoinGrafikDomain {

    fun getBitCoinGrafikValueRemote(): Completable

    fun getBitCoinGrafikValueLocal(): Observable<List<BitCoinChartValue>>
}