package com.neda.propertyapp.provider

import androidx.lifecycle.MutableLiveData
import com.neda.propertyapp.api.PropertyAPI
import com.neda.propertyapp.model.PropertiesData


class Repository(private val propertyAPI: PropertyAPI) {

    suspend fun getProperties() : PropertiesData{
        return propertyAPI.getProperties()
    }

}