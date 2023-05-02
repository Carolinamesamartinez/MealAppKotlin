package com.cmesamartinez.proyecto_appandroidconkotlin.domain

import com.cmesamartinez.proyecto_appandroidconkotlin.data.MealRepo
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse

class SearchByNameUseCase{
     private val repo=MealRepo()
      suspend operator fun invoke(query:String):MealDataResponse?{
         val repo= repo.getMealItems(query)
          return repo
    }
}