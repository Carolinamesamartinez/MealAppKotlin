package com.cmesamartinez.proyecto_appandroidconkotlin.data

import androidx.lifecycle.Transformations.map
import com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao.MealDao
import com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao.MealDatabase
import com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao.MealEntity
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.network.MealService
import com.cmesamartinez.proyecto_appandroidconkotlin.data.network.MealsApiService
import com.cmesamartinez.proyecto_appandroidconkotlin.di.NetworkModule
import com.cmesamartinez.proyecto_appandroidconkotlin.di.NetworkModule_ProvideGetRetrofitFactory.provideGetRetrofit
import com.cmesamartinez.proyecto_appandroidconkotlin.util.Resource
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MealRepo @Inject constructor(
    private val apiMeal : MealService, private val mealDao: MealDao)  {

     suspend fun getMealItems(query:String):MealDataResponse? {
        val result= apiMeal.getMealsServ(query)
       return result
    }


    suspend fun getMealFavorites(): List<MealEntity> {
      return mealDao.getAllFavoritesDrinks()

    }


    suspend fun deleteMealFavorites(meal:MealEntity){
        mealDao.deleteMeal(meal)
    }



    suspend fun insertMealFavorites(meal:MealEntity){
        mealDao.insertFavorite(meal)
    }





}