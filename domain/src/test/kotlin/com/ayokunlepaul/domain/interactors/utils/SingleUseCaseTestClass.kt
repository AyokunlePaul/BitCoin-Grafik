package com.ayokunlepaul.domain.interactors.utils

import com.ayokunlepaul.domain.interactors.base.SingleUseCase
import com.ayokunlepaul.domain.interactors.models.Parameters
import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import io.reactivex.Single

class SingleUseCaseTestClass <T> constructor(
    scheduler: BitCoinGrafikScheduler,
    private val creator: (() -> T)
): SingleUseCase<Parameters, T>(scheduler) {

    override fun buildSingleUseCase(parameter: Parameters?): Single<T> {
        return Single.just(creator.invoke())
    }
}