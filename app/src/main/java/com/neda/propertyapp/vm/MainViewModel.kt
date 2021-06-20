package com.neda.propertyapp.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neda.propertyapp.model.PropertiesData

import com.neda.propertyapp.provider.PropertyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val repository: PropertyRepository)
    : ViewModel() {

    // build connection by retrofit
    //private val repository = Repository(RetrofitInstance.service)

    // build connection manually
    //private val repository = Repository(ManualParsing())

    val propertiesLiveData = MutableLiveData<PropertiesData>()

    init{
        getProperties()
    }

    private fun getProperties() = viewModelScope.launch {
        // IO thread
        val propertiesData =  withContext(Dispatchers.IO){
            repository.getProperties()
        }
        propertiesLiveData.value = propertiesData
    }
}