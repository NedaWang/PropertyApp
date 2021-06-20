package com.neda.propertyapp.model

data class Location(
    val address: String,
    val state: String,
    val suburb: String,
    val postcode: String,
    val latitude: Double,
    val longitude: Double
)
