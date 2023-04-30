package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivityFavoriteMealBinding

private lateinit var binding: ActivityFavoriteMealBinding
class FavoriteMeal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFavoriteMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}