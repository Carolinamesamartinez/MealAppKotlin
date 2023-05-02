package com.cmesamartinez.proyecto_appandroidconkotlin.data

import androidx.lifecycle.Transformations.map
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

class MealRepo  {

    private val apiMeal = MealService()
     suspend fun getMealItems(query:String):MealDataResponse? {
        val result= apiMeal.getMealsServ(query)
       return result
    }

    /**
    fun getMealFavorites(): Call<MealEntity> {
      return mealDatabase.getMealDao().getAllFavoriesDrinks()



    }

**/
    fun convertMealEntityToMeal(mealEntity: MealEntity): MealsItemResponse {
        return MealsItemResponse(
            mealEntity.id,
            mealEntity.name,
            mealEntity.imageMeal,
            mealEntity.category,
            mealEntity.area
        )
    }



    /**
    fun insertMealFavorites(meal:MealEntity){
        mealDatabase.getMealDao().insertFavorite(meal)
    }
**/




}