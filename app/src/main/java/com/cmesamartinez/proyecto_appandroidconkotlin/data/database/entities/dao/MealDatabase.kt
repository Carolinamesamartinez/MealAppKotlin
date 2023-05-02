package com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MealEntity::class], version = 1)
abstract class MealDatabase: RoomDatabase() {
    abstract fun getMealDao(): MealDao


    companion object {
        private var INSTANCE: MealDatabase? = null
        fun getDatabase(context: Context): MealDatabase {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                MealDatabase::class.java,
                "mealsfavorite_table"
            ).build()
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
        //Instance type room of Mealdatbase for not duplicate content

    }
}