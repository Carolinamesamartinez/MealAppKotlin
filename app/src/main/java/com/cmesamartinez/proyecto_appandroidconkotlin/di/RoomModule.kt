package com.cmesamartinez.proyecto_appandroidconkotlin.di

import android.content.Context
import androidx.room.Room
import com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao.MealDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val MEAL_DATABASE_NAME="mealsfavorite_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)= Room.databaseBuilder(context,MealDatabase::class.java,
        MEAL_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db:MealDatabase) = db.getMealDao()
}