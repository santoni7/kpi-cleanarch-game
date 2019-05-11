package com.santoni7.cleanarchgame.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import com.santoni7.cleanarchgame.R
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.ui.base.BaseFragment

class InitGameFragment : BaseFragment() {

    override val layoutResId: Int
        get() = R.layout.init_game_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        val arguments: Bundle = requireActivity().intent.getBundleExtra("arguments")
    }

    private fun init() {

    }


}