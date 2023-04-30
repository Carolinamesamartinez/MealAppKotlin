package com.cmesamartinez.proyecto_appandroidconkotlin.data

import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.network.MealsApiService
import com.cmesamartinez.proyecto_appandroidconkotlin.di.NetworkModule
import com.cmesamartinez.proyecto_appandroidconkotlin.di.NetworkModule_ProvideGetRetrofitFactory.provideGetRetrofit
import com.cmesamartinez.proyecto_appandroidconkotlin.util.Resource
import retrofit2.Call
import javax.inject.Inject

class MealRepo (private val apiMeal:MealsApiService,private val retrofit:NetworkModule) {

     fun getMealItems(query:String):Call<MealDataResponse>{
        val result= apiMeal.getMeals(query=query)
       return result
    }

}