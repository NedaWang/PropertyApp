package com.neda.propertyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neda.propertyapp.adapter.RecyclerAdaper
import com.neda.propertyapp.databinding.ActivityMainBinding
import com.neda.propertyapp.model.PropertiesData
import com.neda.propertyapp.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // data binding
    private lateinit var binding: ActivityMainBinding

    // view model dependency injection
    private val viewModel: MainViewModel by viewModels()

    private lateinit var recyclerAdapter : RecyclerAdaper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //println("viewModel "+viewModel.toString())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    fun setUpRecyclerView(){

        recyclerAdapter = RecyclerAdaper(this,PropertiesData(listOf()))

        binding.recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.propertiesLiveData.observe(this){
            recyclerAdapter.setProperties(it)
        }
    }

}