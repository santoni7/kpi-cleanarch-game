package com.santoni7.cleanarchgame.util


import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> applySchedulers(): ObservableTransformer<T, T> =
    ObservableTransformer { observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }


fun <T> applySchedulersForFlowable(): FlowableTransformer<T, T> =
    FlowableTransformer { observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }


fun <T> applySchedulersForSingle(): SingleTransformer<T, T> =
    SingleTransformer { observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }


fun <T> applySchedulersForMaybe(): MaybeTransformer<T, T> =
    MaybeTransformer { observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }


fun applySchedulersForCompletable(): CompletableTransformer =
    CompletableTransformer { observable -> observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
