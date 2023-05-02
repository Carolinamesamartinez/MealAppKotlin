package com.cmesamartinez.proyecto_appandroidconkotlin.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao.MealEntity
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.domain.SearchByNameUseCase
import kotlinx.coroutines.launch
import retrofit2.Call


class MealViewModel: ViewModel() {

    val mealslist=MutableLiveData<List<MealsItemResponse>?>()
    //meallist es una lista de mealitemresponse-> [{idmeal,nombremeal},{idmeal,nombremeal}] pero necesitamos
    // castear eso es decir para acceder a esa lista necesitamos antes el MealDataResponse
    //cogemos el objeto MealDataResponse de el caso de uso
    //le decimos que acceda a meals(lista de tipo mealitemresponse)
    //entonces le dedimos que el meallist el valor es un conjunto de mealitemresponse
    val meallistEntity= MutableLiveData<Call<MealEntity>>()


     fun getMealList(query:String){

                viewModelScope.launch {
                    val meal=SearchByNameUseCase().invoke(query)
                    if (meal != null) {

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

    /**
    fun guardarMeal(meal:MealEntity){
        viewModelScope.launch {
            repo.insertMealFavorites(meal)
        }
    }
**/
    /**
      fun getMealFavorites(){
          viewModelScope.launch {
              val mealent=repo.getMealFavorites()
              meallistEntity.value=mealent
          }

    }
      **/

    }

