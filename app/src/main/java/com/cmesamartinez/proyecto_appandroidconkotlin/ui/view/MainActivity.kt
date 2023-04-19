package com.cmesamartinez.proyecto_appandroidconkotlin.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.cmesamartinez.proyecto_appandroidconkotlin.data.model.BugsModel
import com.cmesamartinez.proyecto_appandroidconkotlin.data.network.BugsApiService
import com.cmesamartinez.proyecto_appandroidconkotlin.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: BugAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        binding.searchBugs.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean =false


        })
    }

    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val myResult: Response<BugsModel> = retrofit.create(BugsApiService::class.java).getBugs(query)
            if(myResult.isSuccessful){
                val response:BugsModel?=myResult.body()
                if (response!=null){
                    runOnUiThread{
                        adapter.updateList(response.Bugs)
                    }
                }
            }
        }

    }
}