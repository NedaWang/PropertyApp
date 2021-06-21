package com.neda.propertyapp.provider

import com.neda.propertyapp.api.PropertyAPI
import com.neda.propertyapp.model.PropertiesData
import retrofit2.http.GET

interface RetrofitAPI : PropertyAPI{

    @GET("/properties")
    override suspend fun getProperties(): PropertiesData
}