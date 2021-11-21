package com.jamzdeveploment.rescuepetsapp.model

import io.reactivex.rxjava3.observers.DisposableObserver

open class DefaultObserver<T> : DisposableObserver<T>() {
    override fun onNext(t: T?) {
        TODO("Not yet implemented")
    }

    override fun onError(e: Throwable?) {
        TODO("Not yet implemented")
    }

    override fun onComplete() {
        TODO("Not yet implemented")
    }
}