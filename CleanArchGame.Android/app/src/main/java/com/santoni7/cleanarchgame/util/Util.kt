package com.santoni7.cleanarchgame.util

inline fun <reified T> make2DArray(sizeX: Int, sizeY: Int, init: (Int, Int)->T): Array<Array<T>> =
    Array(sizeX) {i -> Array(sizeY){ j -> init(i, j)}}