package com.cmesamartinez.proyecto_appandroidconkotlin.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.cmesamartinez.proyecto_appandroidconkotlin.data.MealRepo
import com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao.MealEntity
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.toDomain
import com.cmesamartinez.proyecto_appandroidconkotlin.domain.SearchByNameUseCase
import com.cmesamartinez.proyecto_appandroidconkotlin.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(private val searchByNameUseCase: SearchByNameUseCase,private val repo:MealRepo): ViewModel() {

    val mealslist=MutableLiveData<List<MealsItemResponse>?>()
    //meallist es una lista de mealitemresponse-> [{idmeal,nombremeal},{idmeal,nombremeal}] pero necesitamos
    // castear eso es decir para acceder a esa lista necesitamos antes el MealDataResponse ya que devueve un objeto que guarda dentro la lista {}
    //cogemos el objeto MealDataResponse de el caso de uso
    //le decimos que acceda a meals(lista de tipo mealitemresponse)
    //entonces le dedimos que el meallist el valor es un conjunto de mealitemresponse
    val meallistEntity= MutableLiveData<List<MealsItemResponse>>()


     fun getMealList(query:String){

                viewModelScope.launch {
                    val meal=searchByNameUseCase.invoke(query)
                    if (meal != null) {
                        //meal {} . lalista de los mealitemresponse correspondientes []
                        mealslist.postValue(meal.meals)
                    }


                }
        }


    /**
    fun searchbyname(query:String){
        viewModelScope.launch{
            val getSearchByNameUseCase:SearchByNameUseCase

            val meal=getSearchByNameUseCase(query)
            mealmodel.postValue(meal)
        }
    }
   **/


    fun guardarMeal(meal:MealEntity){
        viewModelScope.launch {
            repo.insertMealFavorites(meal)
        }
    }


      fun getMealFavorites(){
          viewModelScope.launch {
            val mealent=repo.getMealFavorites()
              meallistEntity.postValue(mealent.map {it.toDomain()})
           }

    }


    }

