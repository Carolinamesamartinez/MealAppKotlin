package com.cmesamartinez.proyecto_appandroidconkotlin.data.model

import com.google.gson.annotations.SerializedName

data class MealDetailResponse(@SerializedName("meals") val meals:List<MealItemDetailResponse>)


data class MealItemDetailResponse(  @SerializedName("idMeal") val mealid:String,
                                    @SerializedName("strMeal") val name:String
                                   ,@SerializedName("strMealThumb") val image:String
                                   ,@SerializedName("strCategory") val category: String
                                   ,@SerializedName("strArea") val area: String
                                   ,@SerializedName("strInstructions") val instructions:String
                                   ,@SerializedName("strIngredient1") val ingrediente1:String
                                   ,@SerializedName("strIngredient2") val ingrediente2:String
                                   ,@SerializedName("strIngredient3") val ingrediente3:String
                                   ,@SerializedName("strIngredient4") val ingrediente4:String
                                   ,@SerializedName("strIngredient5") val ingrediente5:String
                                   ,@SerializedName("strIngredient6") val ingrediente6:String
                                   ,@SerializedName("strIngredient7") val ingrediente7:String
                                   ,@SerializedName("strIngredient8") val ingrediente8:String
                                   ,@SerializedName("strIngredient9") val ingrediente9:String
                                   ,@SerializedName("strTags") val principal:String

)





