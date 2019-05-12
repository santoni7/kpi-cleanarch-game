package com.santoni7.cleanarchgame.ui

import android.os.Bundle

import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import android.util.Log
import androidx.navigation.Navigation
import com.santoni7.cleanarchgame.R

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.transaction {
            add(R.id.fragment_container, CheckerGameFragment())
        }

    }

    fun showProgress(msg: String? = null) {
        //todo
    }

    fun hideProgress() {
        //todo
    }
}
