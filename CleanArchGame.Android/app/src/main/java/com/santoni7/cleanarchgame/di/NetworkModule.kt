package com.santoni7.cleanarchgame.di

import com.google.gson.Gson
import com.santoni7.cleanarchgame.Const
import com.santoni7.cleanarchgame.api.ExampleApi
import dagger.Module
import dagger.Provides
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class NetworkModule {
    @Provides
    @Singleton
    fun okHttpClient(cookieJar: CookieJar): OkHttpClient =
        OkHttpClient.Builder()
            .cookieJar(cookieJar)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    @Provides
    @Singleton
    fun retrofit(client: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(Const.ENDPOINT)
            .build()

    @Provides
    @Singleton
    fun authApi(retrofit: Retrofit): ExampleApi =
        retrofit.create(ExampleApi::class.java)
}
