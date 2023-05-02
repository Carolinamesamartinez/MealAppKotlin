package com.cmesamartinez.proyecto_appandroidconkotlin.data.network

import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDetailResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealItemDetailResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApiService {
     @GET("search.php")
     suspend fun getMeals(@Query("s") query:String): Response<MealDataResponse>

    @GET("lookup.php")
    suspend fun getMealsDetail(@Query("i") query:String):Response<MealDetailResponse>


}