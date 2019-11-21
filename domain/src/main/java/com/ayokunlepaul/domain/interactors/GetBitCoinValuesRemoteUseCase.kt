package com.ayokunlepaul.domain.interactors

import com.ayokunlepaul.domain.interactors.base.SingleUseCase
import com.ayokunlepaul.domain.models.BitCoinChartValue
import com.ayokunlepaul.domain.repository.BitCoinGrafikDomain
import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import com.ayokunlepaul.domain.utils.errors.InvalidParameterException
import io.reactivex.Single
import javax.inject.Inject

class GetBitCoinValuesRemoteUseCase @Inject constructor(
    scheduler: BitCoinGrafikScheduler,
    private val domain: BitCoinGrafikDomain
) : SingleUseCase<GetBitCoinValuesRemoteUseCase.Parameter, List<BitCoinChartValue>>(scheduler) {

    override fun buildSingleUseCase(parameter: Parameter?): Single<List<BitCoinChartValue>> {
        return parameter?.let {
            domain.getBitCoinGrafikValueRemote(
                statType = it.statType,
                queryMap = hashMapOf(
                    "timespan" to it.span
                )
            )
        } ?: throw InvalidParameterException("$parameter")
    }

    data class Parameter(
        val statType: String,
        val span: String
    )
}