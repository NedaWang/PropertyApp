package com.neda.propertyapp.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neda.propertyapp.model.PropertiesData
import com.neda.propertyapp.provider.ManualParsing

import com.neda.propertyapp.provider.Repository
import com.neda.propertyapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    // build connection by retrofit
    private val repository = Repository(RetrofitInstance.service)

    // build connection manually
    // private val repository = Repository(ManualParsing())

    val propertiesLiveData = MutableLiveData<PropertiesData>()

    init{
        viewModelScope.launch {
            // IO thread
            val propertiesData =  withContext(Dispatchers.IO){
                repository.getProperties()
            }
            propertiesLiveData.value = propertiesData
        }
    }
}