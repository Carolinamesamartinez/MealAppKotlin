package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.BugsModel
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ItemBugBinding
import com.squareup.picasso.Picasso

class BugViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val binding=ItemBugBinding.bind(view)

    fun bind(bugsModel: BugsModel){
        binding.tvNameBug.text=bugsModel.nameEU.Realname
        binding.imageBug
        Picasso.get().load(bugsModel.bugsImage).into(binding.imageBug)
    }
}