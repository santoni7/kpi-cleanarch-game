package com.santoni7.cleanarchgame.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.santoni7.cleanarchgame.Name
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ContextModule(val appContext: Context, val deviceToken: String) {
    @Provides
    @Singleton
    fun appContext(): Context = appContext

    @Provides
    @Singleton
    fun gson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Named(Name.DEVICE_TOKEN)
    @Provides fun deviceToken(): String = deviceToken
}