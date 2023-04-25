package com.cmesamartinez.proyecto_appandroidconkotlin.data.model

import com.google.gson.annotations.SerializedName

data class SuperHeroeDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes:List<SuperHeroItemResponse>)

data class SuperHeroItemResponse(
    @SerializedName("id") val superheroid:String,
    @SerializedName("name") val name:String,
    @SerializedName("image") val superheroimage:SuperHeroImageResponse,
)
data class SuperHeroImageResponse(
    @SerializedName("url") val url:String,
)


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

