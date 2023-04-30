package com.cmesamartinez.proyecto_appandroidconkotlin.di


import com.cmesamartinez.proyecto_appandroidconkotlin.data.network.MealsApiService
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
            .baseUrl("https://themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory
            .create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMealApiClient(retrofit: Retrofit):MealsApiService{
        return retrofit.create(MealsApiService::class.java)
    }


}