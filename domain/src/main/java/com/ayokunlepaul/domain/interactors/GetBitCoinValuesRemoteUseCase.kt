package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.interactors.base.CompletableUseCase
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import io.reactivex.Completable
import javax.inject.Inject

class GetBitCoinValuesRemoteUseCase @Inject constructor(
    scheduler: BitCoinGrafikScheduler,
    private val domain: BitCoinGrafikDomain
) : CompletableUseCase<Nothing>(scheduler) {

    override fun buildCompletableUseCase(parameter: Nothing?): Completable {
        return domain.getBitCoinGrafikValueRemote()
    }
}