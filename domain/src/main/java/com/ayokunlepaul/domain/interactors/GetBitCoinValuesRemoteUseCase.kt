package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.interactors.base.SingleUseCase
import com.ayokunlepaul.domain.models.BitCoinChartValue
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class GetBitCoinValuesRemoteUseCase @Inject constructor(
    scheduler: BitCoinGrafikScheduler,
    private val domain: BitCoinGrafikDomain
) : SingleUseCase<Nothing, List<BitCoinChartValue>>(scheduler) {

    override fun buildSingleUseCase(parameter: Nothing?): Single<List<BitCoinChartValue>> {
        return domain.getBitCoinGrafikValueRemote()
    }
}