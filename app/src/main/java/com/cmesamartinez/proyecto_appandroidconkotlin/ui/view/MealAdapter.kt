package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_appandroidconkotlin.R
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse
import javax.inject.Inject

class MealAdapter (var MealList: List<MealsItemResponse> = emptyList(), private val onItemSelected:(String)->Unit):RecyclerView.Adapter<MealViewHolder>() {


    fun updateList(MealList: List<MealsItemResponse>){
        this.MealList=MealList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_meal,parent,false))
    }

    override fun getItemCount(): Int = MealList.size

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(MealList[position],onItemSelected)
    }
}