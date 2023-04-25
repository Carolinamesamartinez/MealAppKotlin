package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ItemBugBinding
import com.squareup.picasso.Picasso

class BugViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding=ItemBugBinding.bind(view)

    fun bind(MealsItemResponse: MealsItemResponse, onItemSelected:(String)->Unit){
        binding.tvNameBug.text=MealsItemResponse.name
        binding.imageBug
        Picasso.get().load(MealsItemResponse.mealImage).into(binding.imageBug)
        binding.tvArea.text=MealsItemResponse.area
        binding.tvCategoryMeal.text=MealsItemResponse.category
        binding.root.setOnClickListener {onItemSelected(MealsItemResponse.mealid) }

    }
}