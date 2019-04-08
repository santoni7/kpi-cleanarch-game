package com.santoni7.cleanarchgame.di

import com.santoni7.cleanarchgame.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = [ContextModule::class, NetworkModule::class, GameCollectionModule::class])
interface AppComponent{
    fun inject(mainActivity: MainActivity)
}