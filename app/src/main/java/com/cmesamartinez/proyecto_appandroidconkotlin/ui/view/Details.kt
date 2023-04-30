package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDetailResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.network.MealsApiService
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Details : AppCompatActivity () {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var malapi:MealsApiService
    companion object{
        const val EXTRA_ID="extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val id:String=intent.getStringExtra(EXTRA_ID).orEmpty()
        getMealInformation(id)
        setContentView(binding.root)
    }

    fun provideGetRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(
                GsonConverterFactory
                .create())
            .build()
    }


    private fun getMealInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val mealDetail=provideGetRetrofit().create(MealsApiService::class.java).getMealsDetail(id)

            mealDetail.enqueue(object : Callback<MealDetailResponse>{
                override fun onResponse(
                    call: Call<MealDetailResponse>,
                    response: Response<MealDetailResponse>
                ) {
                    if(response.body()!=null){
                        runOnUiThread{createUI(response.body()!!)}
                    }
                }


                override fun onFailure(call: Call<MealDetailResponse>, t: Throwable) {
                }




            })

        }
    }


    private fun createUI(MealDetailResponse: MealDetailResponse) {
        Picasso.get().load(MealDetailResponse.meals[0].image).into(binding.ivDetails)
        binding.tvFullName.text=MealDetailResponse.meals[0].ingrediente1
        binding.tvIngr1.text=MealDetailResponse.meals[0].ingrediente2
        binding.tvIngr2.text=MealDetailResponse.meals[0].ingrediente3
        binding.tvIngr3.text=MealDetailResponse.meals[0].ingrediente4
        binding.tvIngr4.text=MealDetailResponse.meals[0].ingrediente5
        binding.tvIngr5.text=MealDetailResponse.meals[0].ingrediente6
        binding.tvIngr6.text=MealDetailResponse.meals[0].ingrediente7
        binding.tvIngr7.text=MealDetailResponse.meals[0].ingrediente8
        binding.tvIngr8.text=MealDetailResponse.meals[0].ingrediente9


    }
}


