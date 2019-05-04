package com.santoni7.cleanarchgame.viewmodel.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.santoni7.cleanarchgame.model.ProgressStatus
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel : ViewModel() {
    protected val TAG: String
        get() = this.javaClass.simpleName


    val progressStatus: MutableLiveData<ProgressStatus> by lazy {
        MutableLiveData<ProgressStatus>()
    }

    protected val disposables: CompositeDisposable by lazy {
        CompositeDisposable()
    }


    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    fun Disposable.saveDisposable() {
        disposables.add(this)
    }

    fun clearDisposables() {
        disposables.clear()
    }
}