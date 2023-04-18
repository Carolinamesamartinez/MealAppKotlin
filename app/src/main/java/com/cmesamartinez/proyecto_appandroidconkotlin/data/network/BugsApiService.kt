package com.cmesamartinez.proyecto_appandroidconkotlin.data.network

import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.BugsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BugsApiService {

    @GET("/{bugID}")
    suspend fun getBugs(@Path("bugID") bugName:String): Response<BugsModel>
}