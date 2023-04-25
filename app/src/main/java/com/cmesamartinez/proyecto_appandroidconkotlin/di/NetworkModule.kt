package com.cmesamartinez.proyecto_appandroidconkotlin.di


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object NetworkModule {


    fun provideGetRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory
            .create())
            .build()
    }

}