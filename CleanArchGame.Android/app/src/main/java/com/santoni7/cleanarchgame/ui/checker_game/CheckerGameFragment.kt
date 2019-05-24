package com.santoni7.cleanarchgame.ui.checker_game

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.santoni7.cleanarchgame.R
import com.santoni7.cleanarchgame.game.player.PlayerType
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.ui.MainActivity
import com.santoni7.cleanarchgame.ui.base.BaseFragment
import com.santoni7.cleanarchgame.viewmodel.CheckerViewModel

class CheckerGameFragment : BaseFragment() {
    override val layoutResId: Int
        get() = R.layout.fragment_checker_game

    private val checkerViewModel by lazy { ViewModelProviders.of(this)[CheckerViewModel::class.java] }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gameEntity: GameEntity = requireActivity().intent.extras.getSerializable(MainActivity.GAME_ENTETY_KEY) as GameEntity
        val opponentType: PlayerType = requireActivity().intent.extras.getSerializable(MainActivity.PLAYER_TYPE_KEY) as PlayerType
        checkerViewModel.onCreate(gameEntity, when(opponentType) {
            PlayerType.AI -> GameMode.AI
            PlayerType.LOCAL -> GameMode.LOCAL
            PlayerType.REMOTE -> GameMode.REMOTE
        })
    }
}