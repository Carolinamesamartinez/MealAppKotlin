package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.BugsModel
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.BugsResponse
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ItemBugBinding
import com.squareup.picasso.Picasso

class BugViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding=ItemBugBinding.bind(view)

    fun bind(bugsResponse: BugsResponse){
        binding.tvNameBug.text= bugsResponse.nameEU.toString()
        binding.imageBug
        Picasso.get().load(bugsResponse.bugsImage).into(binding.imageBug)
    }
}