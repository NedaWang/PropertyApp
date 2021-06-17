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

class MainActivity : AppCompatActivity() {

    // data binding
    private lateinit var binding: ActivityMainBinding
    // view model
    //private lateinit var viewModel: MainViewModel

    private lateinit var recyclerAdapter : RecyclerAdaper
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerAdapter = RecyclerAdaper(this)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        //viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val viewModel: MainViewModel by viewModels()
        viewModel.propertiesLiveData.observe(this){
            //binding.tv.text = it.data[0].description
            //Glide.with(this).load(it.data[0].agent.avatar.medium.url).into(binding.imageView)
            recyclerAdapter.propertiesData = it
            recyclerAdapter.notifyDataSetChanged()

        }
        //viewModel.fetchData()
    }


}