package com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import retrofit2.Call

@Dao
interface MealDao {
/**
    @Query("SELECT * FROM mealsfavorite_table")
     fun getAllFavoriesDrinks(): Call<MealEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertFavorite(meal:MealEntity)
**/
}