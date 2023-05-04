package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmesamartinez.proyecto_appandroidconkotlin.data.database.entities.dao.MealEntity
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivityFavoriteMealBinding
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.viewModel.MealViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@AndroidEntryPoint
class FavoriteMeal : AppCompatActivity() {
    private val mealVM: MealViewModel by viewModels()
    private lateinit var adapter: FavoriteAdapter
    private lateinit var binding: ActivityFavoriteMealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFavoriteMealBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mealVM.getMealFavorites()

       // val list=meallistdatbase.toString().map { MealsItemResponse() }

       // Log.i("fav",  meallistdatbase.toString())
         //val meallistdatbase= mealVM.getMealFavorites()
         //Log.i("fav",  meallistdatbase.toString())

        mealVM.meallistEntity.observe(this) { ob ->
            adapter.updateFavoriteList(ob)
           // val meallistdatbase= mealVM.getMealFavorites()
           // val list=meallistdatbase.toString().map { MealsItemResponse() }
        }

        adapter=FavoriteAdapter()
        binding.rvFavorites.setHasFixedSize(true)
        binding.rvFavorites.layoutManager= LinearLayoutManager(this)
        binding.rvFavorites.adapter=adapter



    }

    private fun detail(id: String) {
        val intent= Intent(this,Details::class.java)
        intent.putExtra(Details.EXTRA_ID,id)
        startActivity(intent)
    }
}


