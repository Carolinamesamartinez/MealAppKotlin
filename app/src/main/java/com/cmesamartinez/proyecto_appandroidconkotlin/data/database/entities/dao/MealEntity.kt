package com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName="mealsfavorite_table")
data class MealEntity (
            @PrimaryKey
            @ColumnInfo(name="idMeal") val id:String,
            @ColumnInfo(name="strMeal") val name:String,
            @ColumnInfo(name="strMealThumb") val imageMeal:String,
            @ColumnInfo(name="strCategory") val category:String,
            @ColumnInfo(name="strArea") val area:String,

    )


