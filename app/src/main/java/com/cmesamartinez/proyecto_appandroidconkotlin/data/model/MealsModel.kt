package com.cmesamartinez.proyecto_appandroidconkotlin.data.model

import com.google.gson.annotations.SerializedName
import dagger.Provides
import javax.inject.Singleton

data class MealDataResponse(
    @SerializedName("meals") val meals:List<MealsItemResponse>
)

data class MealsItemResponse(
    @SerializedName("idMeal") val mealid:String,
    @SerializedName("strMeal") val name:String,
    @SerializedName("strCategory") val category:String,
    @SerializedName("strArea") val area:String,
    @SerializedName("strMealThumb") val mealImage:String
)

