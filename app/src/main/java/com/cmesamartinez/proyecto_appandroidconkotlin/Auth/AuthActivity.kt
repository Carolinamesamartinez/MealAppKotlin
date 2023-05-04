package com.cmesamartinez.proyecto_appandroidconkotlin.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.cmesamartinez.proyecto_appandroidconkotlin.R

import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivityAuthBinding
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.view.MainActivity
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.view.ProviderType
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.inject.Provider

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityAuthBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Splash
        Thread.sleep(200)
        setTheme(R.style.SplashTheme)


        //Analytics Event
        val analytics= FirebaseAnalytics.getInstance(this)
        val bundle=Bundle()
        bundle.putString("message","Firebase completada")
        analytics.logEvent("initScreen",bundle)

        //SetUp
        setUp()
    }

    private fun setUp(){
        title="Authentication"
        binding.btSignIn.setOnClickListener {
            if (binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty())
            {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.etEmail.text.toString(),binding.etEmail.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        showMainSearch(it.result?.user?.email?:"",ProviderType.BASIC)
                    }else{
                        showAlert()
                    }
                }
            }
        }

        binding.btAccess.setOnClickListener {
            if (binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty())
            {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.etEmail.text.toString(),binding.etEmail.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        showMainSearch(it.result?.user?.email?:"",ProviderType.BASIC)
                    }else{
                        showAlert()
                    }
                }
            }
        }
    }

    private fun showAlert(){
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("user error")
        builder.setPositiveButton("Accept",null)
        val dialog:AlertDialog=builder.create()
        dialog.show()

    }

    private fun showMainSearch(email:String,provider: ProviderType){
        val searchIntent= Intent(this,SignOut::class.java).apply {
            putExtra("email",email)
            putExtra("provider",provider.name)
        }
        startActivity(searchIntent)
    }
}