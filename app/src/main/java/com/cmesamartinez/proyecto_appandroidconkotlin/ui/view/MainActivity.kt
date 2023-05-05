package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmesamartinez.proyecto_appandroidconkotlin.data.network.MealsApiService
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivityMainBinding
import com.cmesamartinez.proyecto_appandroidconkotlin.di.NetworkModule.provideGetRetrofit
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.view.Details.Companion.EXTRA_ID
import com.cmesamartinez.proyecto_appandroidconkotlin.ui.viewModel.MealViewModel
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
enum class ProviderType{
    BASIC,
    GOOGLE
}
@AndroidEntryPoint
class MainActivity : AppCompatActivity () {
    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: MealAdapter
    private val mealVM: MealViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit=provideGetRetrofit()
        initUI()


    }


    private fun initUI() {

        binding.ibFavoriteMeal.setOnClickListener {
            favorites()
        }

        binding.searchMeals.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                    mealVM.getMealList(query)

                //searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean =false


        })
        mealVM.isloading.observe(this) { binding.prBar.isVisible = it }

        mealVM.mealslist.observe(this){
            if (it != null) {
                adapter.updateList(it)
            }

        }
        adapter=MealAdapter{ id -> detail(id)}
        binding.rvMeals.setHasFixedSize(true)
        binding.rvMeals.layoutManager=LinearLayoutManager(this)
        binding.rvMeals.adapter=adapter


    }

    private fun detail(id: String) {
        val intent= Intent(this,Details::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }
    private fun favorites() {
        val intent= Intent(this,FavoriteMeal::class.java)
        startActivity(intent)
    }


}