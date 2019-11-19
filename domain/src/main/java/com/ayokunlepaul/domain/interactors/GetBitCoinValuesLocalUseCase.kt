package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.interactors.base.ObservableUseCase
import com.ayokunlepaul.domain.models.BitCoinChartValue
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import io.reactivex.Observable
import javax.inject.Inject

class GetBitCoinValuesLocalUseCase @Inject constructor(
    scheduler: BitCoinGrafikScheduler,
    private val domain: BitCoinGrafikDomain
) : ObservableUseCase<Nothing, List<BitCoinChartValue>>(scheduler) {

    override fun buildObservableUseCase(parameter: Nothing?): Observable<List<BitCoinChartValue>> {
        return domain.getBitCoinGrafikValueLocal()
    }
}