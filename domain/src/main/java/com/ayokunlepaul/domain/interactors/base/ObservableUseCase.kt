package com.ayokunlepaul.domain.interactors.base

import com.ayokunlepaul.domain.utils.BitCoinGrafikScheduler
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

abstract class ObservableUseCase <PARAMETER, RESPONSE> constructor(
    private val scheduler: BitCoinGrafikScheduler
) {
    private val compositeDisposable = CompositeDisposable()

    abstract fun buildObservableUseCase(
        parameter: PARAMETER? = null
    ): Observable<RESPONSE>

    fun executeObservableUseCase(
        parameter: PARAMETER? = null,
        observer: DisposableObserver<RESPONSE>
    ) {
        val disposable = buildObservableUseCase(parameter)
            .subscribeOn(scheduler.executionThread)
            .observeOn(scheduler.observationThread)
            .subscribeWith(observer)
        compositeDisposable.add(disposable)
    }

    fun executeObservableUseCaseAndPerform(
        parameter: PARAMETER? = null,
        onSuccess: (RESPONSE) -> Unit,
        onError: (String?) -> Unit
    ) {
        val disposable = buildObservableUseCase(parameter)
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