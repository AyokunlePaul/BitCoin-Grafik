package com.ayokunlepaul.domain.interactors.base

import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver

abstract class CompletableUseCase <PARAMETER> constructor(
    private val scheduler: BitCoinGrafikScheduler
) {
    private val compositeDisposable = CompositeDisposable()

    abstract fun buildCompletableUseCase(
        parameter: PARAMETER? = null
    ): Completable

    fun executeCompletableUseCase(
        parameter: PARAMETER? = null,
        observer: DisposableCompletableObserver
    ) {
        val disposable = buildCompletableUseCase(parameter)
            .subscribeOn(scheduler.executionThread)
            .observeOn(scheduler.observationThread)
            .subscribeWith(observer)
        compositeDisposable.add(disposable)
    }

    fun executeCompletableUseCaseAndPerform(
        parameter: PARAMETER? = null,
        onSuccess: () -> Unit,
        onError: (String?) -> Unit
    ) {
        val disposable = buildCompletableUseCase(parameter)
            .subscribeOn(scheduler.executionThread)
            .observeOn(scheduler.observationThread)
            .subscribe({
                onSuccess.invoke()
            }) {
                onError.invoke(it.localizedMessage)
            }
        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()
}