package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_appandroidconkotlin.R

class FavoriteAdapter(var mealFavoriteList: List<String> = emptyList()): RecyclerView.Adapter<FavoriteViewHolder>() {


    fun updateFavoriteList(mealFavoriteList: List<String>){
        this.mealFavoriteList=mealFavoriteList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_meal,parent,false))

    }

    override fun getItemCount(): Int =mealFavoriteList.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(mealFavoriteList[position])
    }


}