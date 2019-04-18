package com.santoni7.cleanarchgame.di

import javax.inject.Qualifier

// Use instead of @Named qualifier
annotation class Qualifiers {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class DeviceToken

}
