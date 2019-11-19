package com.ayokunlepaul.blockchaingraph

import com.ayokunlepaul.domain.interactors.GetBitCoinValuesLocalUseCase
import com.ayokunlepaul.domain.interactors.GetBitCoinValuesRemoteUseCase
import com.ayokunlepaul.domain.models.BitCoinChartValue
import javax.inject.Inject

class BlockchainGrafik @Inject constructor(
    private val localUseCase: GetBitCoinValuesLocalUseCase,
    private val remoteUseCase: GetBitCoinValuesRemoteUseCase
) {

    fun getBlockchainValuesRemote() {
        remoteUseCase.executeCompletableUseCaseAndPerform(onSuccess = {

        }) {

        }
    }

    fun getBlockchainValuesLocal(result: (Result<List<BitCoinChartValue>>) -> Unit) {
        localUseCase.executeObservableUseCaseAndPerform(onSuccess = {
            result.invoke(Result.success(it))
        }) {
            result.invoke(Result.failure(Throwable(it)))
        }
    }

    fun cleanUp() {
        remoteUseCase.dispose()
        localUseCase.dispose()
    }
}