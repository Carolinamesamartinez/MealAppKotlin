package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ItemMealBinding
import com.squareup.picasso.Picasso

class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding= ItemMealBinding.bind(view)


    fun bind(item: MealsItemResponse){
        binding.tvNameMeal.text=item.name
        binding.imageMeal
        Picasso.get().load(item.mealImage).into(binding.imageMeal)
        binding.tvArea.text=item.area
        binding.tvCategoryMeal.text=item.category

         }

    }
