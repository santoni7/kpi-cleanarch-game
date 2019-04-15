package com.santoni7.cleanarchgame.game.chess

class BoardCell{

    var figure: Figure? = null
        set(value) {
            field = value
            isFree = field == null
        }
    var isFree: Boolean = true

    fun clear() {
        figure = null
    }
}