package com.ayokunlepaul.blockchaingraph

import com.ayokunlepaul.domain.interactors.GetBitCoinValuesRemoteUseCase
import com.ayokunlepaul.domain.models.BitCoinChartValue
import javax.inject.Inject

class BlockchainGrafik @Inject constructor(
    private val remoteUseCase: GetBitCoinValuesRemoteUseCase
) {

    fun getBitCoinValuesRemote(
        type: String,
        span: String,
        result: (Result<List<BitCoinChartValue>>) -> Unit
    ) {
        val parameter = GetBitCoinValuesRemoteUseCase.Parameter(
            statType = type,
            span = span
        )
        remoteUseCase.executeSingleUseCaseAndPerform(parameter, {
            result.invoke(Result.success(it))
        }) {
            result.invoke(Result.failure(Throwable(it)))
        }
    }

    fun cleanUp() {
        remoteUseCase.dispose()
    }
}