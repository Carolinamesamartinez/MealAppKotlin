package com.cmesamartinez.proyecto_appandroidconkotlin.domain

import android.util.Log
import androidx.core.view.isVisible
import com.cmesamartinez.proyecto_appandroidconkotlin.data.MealRepo
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.network.MealsApiService
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.view.MealAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SearchByNameUseCase @Inject constructor(private val repo: MealRepo,private val adapter:MealAdapter) {
    suspend  operator fun invoke(query:String):Call<MealDataResponse>?{
        val meal=repo.getMealItems(query = query)
        meal.enqueue(object: Callback<MealDataResponse> {
            override fun onResponse(
                call: Call<MealDataResponse>,
                response: Response<MealDataResponse>
            ) {
                if(response.isSuccessful){
                    val response=response.body()
                    if (response!=null){
                           val prueba= adapter.updateList(response.meals)
                        return prueba
                    }
                }else{

                    Log.i("proyecto","no")
                }
            }

            override fun onFailure(call: Call<MealDataResponse>, t: Throwable) {

            }

        })
        return null
    }
}