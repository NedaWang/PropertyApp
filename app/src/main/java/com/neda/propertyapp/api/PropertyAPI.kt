package com.neda.propertyapp.api

import com.neda.propertyapp.model.PropertiesData

// get properties info
interface PropertyAPI {
    // coroutine will decide if it will run on main thread or background thread
    suspend fun getProperties(): PropertiesData
}