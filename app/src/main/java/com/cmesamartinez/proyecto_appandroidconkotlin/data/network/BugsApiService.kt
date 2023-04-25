package com.cmesamartinez.proyecto_appandroidconkotlin.data.network

import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDetailResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.SuperHeroeDataResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BugsApiService {

    /**
    @GET("/api/224080986877328/search/super/{name}")
    suspend fun getSuperHeroes(@Path("name") superheroName:String):Response<SuperHeroeDataResponse>
    **/
    @GET("search.php")
     fun getSuperHeroes(@Query("s") superheroName:String): Call<MealDataResponse>
     /**
    @GET("/api/224080986877328/{id}")
    suspend fun getSuperHeroeDetail(@Path("id") superheroName:String):Response<SuperHeroDetailResponse>
    **/
    @GET("lookup.php")
     fun getSuperHeroeDetail(@Query("i") superheroName:String):Call<MealDetailResponse>
}