package com.santoni7.cleanarchgame.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction
import com.santoni7.cleanarchgame.R


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
