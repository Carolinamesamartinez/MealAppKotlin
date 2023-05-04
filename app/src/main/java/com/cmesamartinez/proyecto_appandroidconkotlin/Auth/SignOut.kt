package com.cmesamartinez.proyecto_appandroidconkotlin.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cmesamartinez.proyecto_appandroidconkotlin.R
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivitySignOutBinding
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.view.MainActivity
import com.google.firebase.auth.FirebaseAuth

class SignOut : AppCompatActivity() {
    private lateinit var binding: ActivitySignOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignOutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setUp
        val bundle=intent.extras
        val email=bundle?.getString("email")
        val provider=bundle?.getString("provider")
        setUp(email?:"",provider?:"")
    }

    private fun setUp(email:String,provider:String) {

        title="Inicio"
        binding.tvEmail.text=email
        binding.tvPassword.text=provider
        binding.btSignOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btApp.setOnClickListener {
            val app= Intent(this,MainActivity::class.java)
            startActivity(app)
        }
    }
}