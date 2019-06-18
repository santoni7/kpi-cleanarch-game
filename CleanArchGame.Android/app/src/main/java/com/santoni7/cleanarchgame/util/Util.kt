package com.santoni7.cleanarchgame.util

import android.graphics.Color

inline fun <reified T> make2DArray(sizeX: Int, sizeY: Int, init: (Int, Int) -> T): Array<Array<T>> =
    Array(sizeX) { i -> Array(sizeY) { j -> init(i, j) } }

fun makeColor(r: Int, g: Int, b: Int, a: Int = 255) = Color.argb(a, r, g, b)
fun makeColor(r: Float, g: Float, b: Float, a: Float = 1f) =
    { fl: Float -> (255f * fl).toInt() }.let { conv ->
        Color.argb(conv(a), conv(r), conv(g), conv(b))
    }

//{
//    val map = { fl: Float -> (255f * fl).toInt() }
//    map.run {  }
//
//    return Color.argb(map(a), map(r), map(g), map(b))
//}

