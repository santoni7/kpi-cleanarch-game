package com.santoni7.cleanarchgame.presentation.ui.start_screen

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santoni7.cleanarchgame.R
import com.santoni7.cleanarchgame.game.player.PlayerType
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.ProgressStatus
import com.santoni7.cleanarchgame.presentation.ui.MainActivity
import com.santoni7.cleanarchgame.presentation.ui.adapters.GamesAdapter
import com.santoni7.cleanarchgame.presentation.ui.base.BaseFragment
import com.santoni7.cleanarchgame.presentation.viewmodel.StartViewModel
import kotlinx.android.synthetic.main.choose_game_fragment.*

class StartFragment : BaseFragment() {

    companion object {
        private val TAG = StartFragment::class.simpleName
    }

    override val layoutResId: Int
        get() = R.layout.choose_game_fragment

    private var gamesViewModel: StartViewModel? = null
    private var gamesAdapter: GamesAdapter = GamesAdapter(mutableListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initGamesRecyclerView()
        start_game_button.setOnClickListener { startGame() }
        gamesViewModel?.initGamesList()
    }

    private fun startGame() {
        val game: GameEntity? = gamesAdapter.chosenGame
        val player: PlayerType? = when(opponents_radio_group.checkedRadioButtonId) {
            R.id.local_opponent_radio_button -> PlayerType.LOCAL
            R.id.remote_opponent_radio_button -> PlayerType.REMOTE
            R.id.ai_opponent_radio_button -> PlayerType.AI
            else -> null
        }
        if(game == null  || player == null) showError("Input correct data")
        else openGameActivity(game, player)
    }

    private fun initGamesRecyclerView() {
        games_recycler_view.layoutManager = LinearLayoutManager(hostActivity, RecyclerView.VERTICAL, false)
        games_recycler_view.adapter = gamesAdapter
    }

    private fun initViewModel() {
        if(gamesViewModel != null) return
        gamesViewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)
        gamesViewModel!!.progressStatus.observe(this, Observer { configLoading(it) })
        gamesViewModel!!.gamesListLiveData.observe(this, Observer { displayGamesList(it) })
        gamesViewModel!!.errorLiveData.observe(this, Observer { showError(it) })
    }

    private fun openGameActivity(gameEntity: GameEntity, playerType: PlayerType) {
        val intent = MainActivity.newIntent(requireContext(), gameEntity, playerType)
        startActivity(intent)
    }

    private fun showError(message: String) {
        Log.e(TAG, message)
        Toast.makeText(hostActivity, message, Toast.LENGTH_LONG).show()
    }

    private fun displayGamesList(games: List<GameEntity>) {
        gamesAdapter.swapData(games)
    }

    private fun configLoading(progressStatus: ProgressStatus) {
        when(progressStatus.state) {
            ProgressStatus.State.LOADING -> showProgress(progressStatus.message)
            ProgressStatus.State.DONE -> hideProgress()
        }
    }

    override fun onDestroy() {
        gamesViewModel?.disconnect()
        super.onDestroy()
    }
}