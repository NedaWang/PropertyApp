package com.neda.propertyapp.provider

import androidx.lifecycle.MutableLiveData
import com.neda.propertyapp.api.PropertyAPI
import com.neda.propertyapp.model.PropertiesData
import javax.inject.Inject
import javax.inject.Singleton

// data repository
class PropertyRepository
@Inject
constructor(private val propertyAPI: PropertyAPI) {
    suspend fun getProperties() = propertyAPI.getProperties()
}