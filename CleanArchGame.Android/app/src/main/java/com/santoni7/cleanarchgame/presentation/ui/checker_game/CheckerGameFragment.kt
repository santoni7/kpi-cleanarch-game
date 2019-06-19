package com.santoni7.cleanarchgame.presentation.ui.checker_game

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.santoni7.cleanarchgame.R
import com.santoni7.cleanarchgame.game.common.FigureColor
import com.santoni7.cleanarchgame.game.player.PlayerType
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.GameMode
import com.santoni7.cleanarchgame.presentation.ui.MainActivity
import com.santoni7.cleanarchgame.presentation.ui.base.BaseFragment
import com.santoni7.cleanarchgame.presentation.viewmodel.CheckerViewModel
import kotlinx.android.synthetic.main.fragment_checker_game.*

class CheckerGameFragment : BaseFragment() {
    override val layoutResId: Int
        get() = R.layout.fragment_checker_game

    private val checkerViewModel by lazy { ViewModelProviders.of(this)[CheckerViewModel::class.java] }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gameEntity: GameEntity = requireActivity().intent.extras.getSerializable(MainActivity.GAME_ENTETY_KEY) as GameEntity
        val opponentType: PlayerType = requireActivity().intent.extras.getSerializable(MainActivity.PLAYER_TYPE_KEY) as PlayerType
        checkerViewModel.onCreate(when(opponentType) {
            PlayerType.AI -> GameMode.AI
            PlayerType.LOCAL -> GameMode.LOCAL
            PlayerType.REMOTE -> GameMode.REMOTE
        })

        move_button.setOnClickListener { moveFigure() }
    }

    private fun moveFigure() {
        val move: String = move_edit.text.toString()
        val parts = move.split(" ")
        checkerViewModel.onBoardCellClick(
            parts[0].toInt(),
            parts[1].toInt(),
            parts[2].toInt(),
            parts[3].toInt(),
            if(parts[4].toInt() == 1) FigureColor.WHITE else FigureColor.BLACK
        )
    }
}