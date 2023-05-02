package com.cmesamartinez.proyecto_appandroidconkotlin.data.network

import android.util.Log
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.di.NetworkModule
import com.cmesamartinez.proyecto_appandroidconkotlin.di.NetworkModule_ProvideGetRetrofitFactory.provideGetRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MealService {
    private val apimeal = provideGetRetrofit().create(MealsApiService::class.java)

    suspend fun getMealsServ(query: String): MealDataResponse? {
        return withContext(Dispatchers.IO) {
            val response = apimeal.getMeals(query)

            if (response.isSuccessful) {
                Log.i("carolina",response.toString())
                val body= response.body()
                Log.i("carol2",body.toString())
                response.body()

            } else {
                Log.i("carol2","no funciona")

                null
            }
        }

    }
}