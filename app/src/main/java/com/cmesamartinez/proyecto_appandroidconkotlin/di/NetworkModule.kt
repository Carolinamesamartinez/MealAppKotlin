package com.cmesamartinez.proyecto_appandroidconkotlin.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGetRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("http://acnhapi.com/")
            .addConverterFactory(GsonConverterFactory
            .create())
            .build()
    }

}