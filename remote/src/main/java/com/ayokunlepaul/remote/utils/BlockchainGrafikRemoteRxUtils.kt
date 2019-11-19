package com.ayokunlepaul.remote.utils

import io.reactivex.Single

fun <T> Single<T>.doOnError(): Single<T> {
    return onErrorResumeNext { throwable: Throwable ->
        Single.error<T>(
            Throwable(BlockchainGrafikRemoteErrorExtractor.extractErrorMessage(throwable))
        )
    }
}