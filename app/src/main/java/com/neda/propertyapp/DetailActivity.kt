package com.neda.propertyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neda.propertyapp.databinding.ActivityDetailBinding
import com.neda.propertyapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id : String = intent.getStringExtra("id").toString()
        binding.textView.text = id
    }
}