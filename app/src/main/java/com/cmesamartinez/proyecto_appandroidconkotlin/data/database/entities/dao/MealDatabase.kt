package com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MealEntity::class], version = 1)
abstract class MealDatabase: RoomDatabase() {
    abstract fun getMealDao(): MealDao

}