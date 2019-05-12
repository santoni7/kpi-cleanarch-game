package com.santoni7.cleanarchgame.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.santoni7.cleanarchgame.R
import com.santoni7.cleanarchgame.viewmodel.CheckerViewModel

class CheckerGameFragment : BaseFragment() {
    override val layoutResId: Int
        get() = R.layout.fragment_checker_game

    private val checkerViewModel by lazy { ViewModelProviders.of(this)[CheckerViewModel::class.java] }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}