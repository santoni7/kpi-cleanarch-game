package com.santoni7.cleanarchgame.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santoni7.cleanarchgame.R
import com.santoni7.cleanarchgame.model.GameEntity

class GamesAdapter(private val data: List<GameEntity>, private val onGameClickListener: OnGameClickListener) :
    RecyclerView.Adapter<GamesViewHolder>(){

    interface OnGameClickListener {
        fun onGameClick(gameEntity: GameEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val hView = LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)
        hView.setOnClickListener { onGameClickListener.onGameClick(data[viewType]) }
        return GamesViewHolder(hView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}