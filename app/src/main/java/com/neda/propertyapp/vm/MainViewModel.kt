package com.neda.propertyapp.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neda.propertyapp.model.PropertiesData
import com.neda.propertyapp.provider.ManualParsing

import com.neda.propertyapp.provider.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    //private val repository = Repository(RetrofitInstance.service)
    private val repository = Repository(ManualParsing())

    val propertiesLiveData = MutableLiveData<PropertiesData>()

    init{
        Log.d("initVM","initVM")
        viewModelScope.launch {
            val propertiesData =  withContext(Dispatchers.IO){
                repository.getProperties()
            }
            propertiesLiveData.value = propertiesData
        }
    }
}