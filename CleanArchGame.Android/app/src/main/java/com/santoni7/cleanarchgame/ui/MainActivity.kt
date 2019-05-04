package com.santoni7.cleanarchgame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import android.R
import android.util.Log

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.santoni7.cleanarchgame.R.layout.activity_main)


    }

    fun showProgress(msg: String? = null) {
        //todo
    }

    fun hideProgress() {
        //todo
    }
}
