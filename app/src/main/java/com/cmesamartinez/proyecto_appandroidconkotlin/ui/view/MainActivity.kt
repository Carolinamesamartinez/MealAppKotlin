package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.network.MealsApiService
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivityMainBinding
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.view.Details.Companion.EXTRA_ID
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.viewModel.MealViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : AppCompatActivity () {
    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: MealAdapter
    private val mealVM: MealViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit=provideGetRetrofit()
        initUI()
    }

    fun provideGetRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initUI() {
        binding.searchMeals.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    mealVM.getMealList(query)
                }
                //searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean =false


        })
        mealVM.mealslist.observe(this){ results->
            results.enqueue(object:Callback<MealDataResponse>{
                override fun onResponse(
                    call: Call<MealDataResponse>,
                    response: Response<MealDataResponse>
                ) {
                    if(response.isSuccessful){
                        val response= response.body()
                        if (response!=null){
                            runOnUiThread {
                                adapter.updateList(response.meals)
                            }

                        }

                    }
                }

                override fun onFailure(call: Call<MealDataResponse>, t: Throwable) {
                }

            })

        }
        adapter=MealAdapter{ id -> detail(id)}
        binding.rvMeals.setHasFixedSize(true)
        binding.rvMeals.layoutManager=LinearLayoutManager(this)
        binding.rvMeals.adapter=adapter


    }

    private fun detail(id: String) {
        val intent= Intent(this,Details::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }


    private fun searchByName(query: String) {
        binding.prBar.isVisible=true
        CoroutineScope(Dispatchers.IO).launch {

            val myResult= provideGetRetrofit().create(MealsApiService::class.java).getMeals(query)
            myResult.enqueue(object:Callback<MealDataResponse>{
                override fun onResponse(
                    call: Call<MealDataResponse>,
                    response: Response<MealDataResponse>
                ) {
                    if(response.isSuccessful){
                        val response=response.body()
                        if (response!=null){
                            runOnUiThread{
                                adapter.updateList(response.meals)
                                binding.prBar.isVisible=false

                            }
                        }
                    }else{
                        Log.i("proyecto","no")
                    }
                }

                override fun onFailure(call: Call<MealDataResponse>, t: Throwable) {

                }

            })

        }

    }
}