package com.santoni7.cleanarchgame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.santoni7.cleanarchgame.R

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
}