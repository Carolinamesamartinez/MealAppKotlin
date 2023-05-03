package com.cmesamartinez.proyecto_appandroidconkotlin.domain

import com.cmesamartinez.proyecto_appandroidconkotlin.data.MealRepo
import com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao.MealEntity
import javax.inject.Inject

class SaveMealUseCase @Inject constructor(private val repo:MealRepo) {

    suspend operator fun invoke(meal:MealEntity){
        repo.insertMealFavorites(meal)

    }
}