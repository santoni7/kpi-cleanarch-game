package com.santoni7.cleanarchgame.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle

import com.santoni7.cleanarchgame.R

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction
import androidx.navigation.Navigation
import com.santoni7.cleanarchgame.game.player.PlayerType
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.ui.checker_game.CheckerGameFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showProgress(msg: String? = null) {
        //todo
    }

    fun hideProgress() {
        //todo
    }

    companion object {

        const val GAME_ENTETY_KEY = "game_entity"
        const val PLAYER_TYPE_KEY = "player_type"

        fun newIntent(context: Context, gameEntity: GameEntity, playerType: PlayerType): Intent {
            return Intent(context, MainActivity::class.java).apply {
                putExtra(PLAYER_TYPE_KEY, playerType)
                putExtra(GAME_ENTETY_KEY, gameEntity)
            }
        }
    }
}
