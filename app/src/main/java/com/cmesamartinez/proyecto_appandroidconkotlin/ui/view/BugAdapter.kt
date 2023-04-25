package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_appandroidconkotlin.R
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.MealsItemResponse

class BugAdapter(var BugList: List<MealsItemResponse> = emptyList(),private val onItemSelected:(String)->Unit):RecyclerView.Adapter<BugViewHolder>() {


    fun updateList(BugList: List<MealsItemResponse>){
        this.BugList=BugList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BugViewHolder {
        return BugViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_bug,parent,false))
    }

    override fun getItemCount(): Int = BugList.size

    override fun onBindViewHolder(holder: BugViewHolder, position: Int) {
        holder.bind(BugList[position],onItemSelected)
    }
}