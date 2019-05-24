package com.santoni7.cleanarchgame.ui.start_screen

import com.santoni7.cleanarchgame.R
import com.santoni7.cleanarchgame.ui.base.HostActivity

class StartActivity : HostActivity() {
    override fun getLayoutRes() = R.layout.start_activity

    override fun showProgress(msg: String?) {
    }

    override fun hideProgress() {
    }
}