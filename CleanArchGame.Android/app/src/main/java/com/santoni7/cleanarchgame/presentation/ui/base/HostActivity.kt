package com.santoni7.cleanarchgame.presentation.ui.base

abstract class HostActivity : BaseActivity() {

    abstract fun showProgress(msg: String? = null)

    abstract fun hideProgress()
}