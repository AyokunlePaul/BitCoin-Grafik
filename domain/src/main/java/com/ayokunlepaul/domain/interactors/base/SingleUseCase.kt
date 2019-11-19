package com.ayokunlepaul.domain.interactors.base

import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

abstract class SingleUseCase <PARAMETER, RESPONSE> constructor(
    private val scheduler: BitCoinGrafikScheduler
) {
    private val compositeDisposable = CompositeDisposable()

    abstract fun buildSingleUseCase(
        parameter: PARAMETER? = null
    ): Single<RESPONSE>

    fun executeSingleUseCase(
        parameter: PARAMETER? = null,
        observer: DisposableSingleObserver<RESPONSE>
    ) {
        val disposable = buildSingleUseCase(parameter)
            .subscribeOn(scheduler.executionThread)
            .observeOn(scheduler.observationThread)
            .subscribeWith(observer)
        compositeDisposable.add(disposable)
    }

    fun executeSingleUseCaseAndPerform(
        parameter: PARAMETER? = null,
        onSuccess: (RESPONSE) -> Unit,
        onError: (String?) -> Unit
    ) {
        val disposable = buildSingleUseCase(parameter)
            .subscribeOn(scheduler.executionThread)
            .observeOn(scheduler.observationThread)
            .subscribe({
                onSuccess.invoke(it)
            }) {
                onError.invoke(it.localizedMessage)
            }
        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()
}