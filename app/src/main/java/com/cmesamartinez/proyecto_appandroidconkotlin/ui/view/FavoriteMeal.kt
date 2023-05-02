package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao.MealEntity
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivityFavoriteMealBinding
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.viewModel.MealViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class FavoriteMeal : AppCompatActivity() {
    private val mealVM: MealViewModel by viewModels()
    private lateinit var adapter: FavoriteAdapter
    private lateinit var binding: ActivityFavoriteMealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFavoriteMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**
        mealVM.getMealFavorites()
        mealVM.meallistEntity.observe(this) { ob ->
            ob.enqueue(object : Callback<MealEntity> {
                override fun onResponse(call: Call<MealEntity>, response: Response<MealEntity>) {
                    if(response.isSuccessful){
                        val response= response.body()
                        if (response!=null){
                            runOnUiThread {
                                val list: List<String> = listOf(response.id,response.imageMeal,response.area,response.category,response.name)
                                adapter.updateFavoriteList(list)
                            }

                        }

                    }
                }

                override fun onFailure(call: Call<MealEntity>, t: Throwable) {

                }

            })

        }

        adapter=FavoriteAdapter()
        binding.rvFavorites.setHasFixedSize(true)
        binding.rvFavorites.layoutManager= LinearLayoutManager(this)
        binding.rvFavorites.adapter=adapter

    **/

    }
}


