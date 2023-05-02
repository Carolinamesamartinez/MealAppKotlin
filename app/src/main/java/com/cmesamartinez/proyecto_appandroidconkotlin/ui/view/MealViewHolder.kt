package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealDataResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ItemMealBinding
import com.squareup.picasso.Picasso

class MealViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding=ItemMealBinding.bind(view)

    fun bind(MealsItemResponse: MealsItemResponse, onItemSelected:(String)->Unit){
        binding.tvNameMeal.text=MealsItemResponse.name
        binding.imageMeal
        Picasso.get().load(MealsItemResponse.mealImage).into(binding.imageMeal)
        binding.tvArea.text=MealsItemResponse.area
        binding.tvCategoryMeal.text=MealsItemResponse.category
        binding.root.setOnClickListener {onItemSelected(MealsItemResponse.mealid) }

    }


}