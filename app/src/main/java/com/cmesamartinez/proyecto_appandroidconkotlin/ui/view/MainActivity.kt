package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cmesamartinez.proyecto_appandroidconkotlin.R
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}