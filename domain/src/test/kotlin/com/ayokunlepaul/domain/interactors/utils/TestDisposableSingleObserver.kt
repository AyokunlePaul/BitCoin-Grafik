package com.ayokunlepaul.domain.interactors.utils

import io.reactivex.observers.DisposableSingleObserver

class TestDisposableSingleObserver <T> : DisposableSingleObserver<T>() {

    var values = 0

    override fun onSuccess(t: T) {
        values++
    }

    override fun onError(e: Throwable) {}
}