package com.neda.propertyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neda.propertyapp.databinding.ActivityPropertyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PropertyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPropertyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}