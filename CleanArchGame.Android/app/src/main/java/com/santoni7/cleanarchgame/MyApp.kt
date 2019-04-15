package com.santoni7.cleanarchgame

import android.annotation.SuppressLint
import android.app.Application
import android.provider.Settings
import com.santoni7.cleanarchgame.di.AppComponent
import com.santoni7.cleanarchgame.di.ContextModule
import com.santoni7.cleanarchgame.di.DaggerAppComponent

class MyApp : Application() {
    @SuppressLint("HardwareIds")
    override fun onCreate() {
        super.onCreate()
        val deviceId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)

        component = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext, deviceId))
            .build()
    }

    companion object {
        lateinit var component: AppComponent
    }
}