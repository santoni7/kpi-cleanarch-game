package com.santoni7.cleanarchgame.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santoni7.cleanarchgame.R
import com.santoni7.cleanarchgame.model.GameEntity

class GamesAdapter(private val data: MutableList<GameEntity>) :
    RecyclerView.Adapter<GamesViewHolder>(){

    var chosenGame: GameEntity? = null
    private var lastCheckedView: View? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val hView = LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)
        return GamesViewHolder(hView, chosenGame)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun swapData(newData: List<GameEntity>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            chosenGame = data[position]
            lastCheckedView?.setBackgroundColor(Color.GRAY)
            lastCheckedView = holder.itemView
            lastCheckedView?.setBackgroundColor(Color.GREEN)

        }
        holder.bind(data[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}