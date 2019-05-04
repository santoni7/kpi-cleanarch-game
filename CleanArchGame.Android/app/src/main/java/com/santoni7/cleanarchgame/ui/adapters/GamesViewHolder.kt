package com.santoni7.cleanarchgame.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.santoni7.cleanarchgame.model.GameEntity
import kotlinx.android.synthetic.main.game_item.view.*

class GamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(gameEntity: GameEntity) {
        itemView.choose_game_button.text = gameEntity.title
    }
}