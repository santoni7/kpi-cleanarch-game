package com.santoni7.cleanarchgame.ui.start_screen

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santoni7.cleanarchgame.R
import com.santoni7.cleanarchgame.model.GameEntity
import com.santoni7.cleanarchgame.model.ProgressStatus
import com.santoni7.cleanarchgame.ui.adapters.GamesAdapter
import com.santoni7.cleanarchgame.ui.base.BaseFragment
import com.santoni7.cleanarchgame.viewmodel.GameChooseViewModel
import kotlinx.android.synthetic.main.choose_game_fragment.*

class GameChooseFragment : BaseFragment(), GamesAdapter.OnGameClickListener {

    companion object {
        private val TAG = GameChooseFragment::class.simpleName
    }

    override val layoutResId: Int
        get() = R.layout.choose_game_fragment

    private var gamesViewModel: GameChooseViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initGamesRecyclerView()
        gamesViewModel?.initGamesList()
    }

    private fun initGamesRecyclerView() {
        games_recycler_view.layoutManager = LinearLayoutManager(hostActivity, RecyclerView.VERTICAL, false)
    }

    private fun initViewModel() {
        if(gamesViewModel != null) return
        gamesViewModel = ViewModelProviders.of(this).get(GameChooseViewModel::class.java)
        gamesViewModel!!.progressStatus.observe(this, Observer { configLoading(it) })
        gamesViewModel!!.gamesListLiveData.observe(this, Observer { displayGamesList(it) })
        gamesViewModel!!.errorLiveData.observe(this, Observer { showError(it) })
    }

    private fun showError(message: String) {
        Log.e(TAG, message)
        Toast.makeText(hostActivity, message, Toast.LENGTH_LONG).show()
    }

    private fun displayGamesList(games: List<GameEntity>) {
        games_recycler_view.adapter = GamesAdapter(games, this)
    }

    private fun configLoading(progressStatus: ProgressStatus) {
        when(progressStatus.state) {
            ProgressStatus.State.LOADING -> showProgress(progressStatus.message)
            ProgressStatus.State.DONE -> hideProgress()
        }
    }

    override fun onGameClick(gameEntity: GameEntity) {
        gamesViewModel?.chooseGame(gameEntity)
    }
}