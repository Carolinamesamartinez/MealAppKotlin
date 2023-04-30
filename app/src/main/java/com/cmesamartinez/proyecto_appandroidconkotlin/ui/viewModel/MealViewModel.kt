package com.cmesamartinez.proyecto_appandroidconkotlin.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmesamartinez.proyecto_appandroidconkotlin.data.MealRepo
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.network.MealsApiService
import com.cmesamartinez.proyecto_appandroidconkotlin.di.NetworkModule
import com.cmesamartinez.proyecto_appandroidconkotlin.domain.SearchByNameUseCase
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.view.MealAdapter
import com.cmesamartinez.proyecto_appandroidconkotlin.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


class MealViewModel: ViewModel() {
private  var repo: MealRepo

    val mealslist=MutableLiveData<Call<MealDataResponse>>()
init{
    val retrofit:Retrofit
    retrofit=NetworkModule.provideGetRetrofit()
    val apiMealsApiService:MealsApiService=retrofit.create(MealsApiService::class.java)
    val networkModule=NetworkModule
    repo=MealRepo(apiMealsApiService,networkModule)
}
     fun getMealList(query:String){

                viewModelScope.launch {
                    val meal=repo.getMealItems(query)
                    //mealslist.postValue(meal)
                    mealslist.value=meal

                }
        }
    }

