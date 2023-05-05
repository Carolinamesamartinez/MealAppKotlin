package com.cmesamartinez.proyecto_appandroidconkotlin.Auth

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.cmesamartinez.proyecto_appandroidconkotlin.R

import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivityAuthBinding
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.view.ProviderType
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    private val GOOGLE_SIGN_IN=100
    private var our_request_code:Int=123
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
        session()
    }


    override fun onStart() {
        super.onStart()
        binding.authLayout.visibility= View.VISIBLE

    }
    private fun session() {
        val prefs= getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val email=prefs.getString("email",null)
        val provider=prefs.getString("provider",null)
        if(email!=null && provider!=null){
            binding.authLayout.visibility= View.INVISIBLE
            showSignOut(email,ProviderType.valueOf(provider))
        }
    }

    private fun setUp(){
        title="Authentication"
        binding.btSignIn.setOnClickListener {
            if (binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty())
            {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.etEmail.text.toString(),binding.etEmail.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        showSignOut(it.result?.user?.email?:"",ProviderType.BASIC)
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
                        showSignOut(it.result?.user?.email?:"",ProviderType.BASIC)
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
        builder.setMessage("Usuario incorrecto")
        builder.setPositiveButton("Accept",null)
        val dialog:AlertDialog=builder.create()
        dialog.show()

    }

    private fun showSignOut(email:String, provider: ProviderType){
        val searchIntent= Intent(this,SignOut::class.java).apply {
            putExtra("email",email)
            putExtra("provider",provider.name)
        }
        startActivity(searchIntent)
    }
}