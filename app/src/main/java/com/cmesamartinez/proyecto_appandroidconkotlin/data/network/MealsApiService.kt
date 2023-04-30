package com.cmesamartinez.proyecto_appandroidconkotlin.data.network

import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApiService {


    @GET("search.php")
     fun getMeals(@Query("s") query:String): Call<MealDataResponse>

    @GET("lookup.php")
     fun getMealsDetail(@Query("i") query:String):Call<MealDetailResponse>


}