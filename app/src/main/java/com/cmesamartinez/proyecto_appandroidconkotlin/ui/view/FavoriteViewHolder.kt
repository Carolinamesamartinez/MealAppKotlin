package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ItemMealBinding
import com.squareup.picasso.Picasso

class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding= ItemMealBinding.bind(view)


    fun bind(MealEntity: String){
        /**
        binding.tvNameMeal.text=MealEntity.id
        binding.imageMeal
        Picasso.get().load(MealEntity.imageMeal).into(binding.imageMeal)
        binding.tvArea.text=MealEntity.area
        binding.tvCategoryMeal.text=MealEntity.category
        **/
         }

    }
