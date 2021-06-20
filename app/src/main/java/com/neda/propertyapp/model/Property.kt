package com.neda.propertyapp.model

data class Property (
    val id: String,
    val auction_date: String,
    val available_from: String,
    val bedrooms: Int,
    val bathrooms: Int,
    val carspaces: Int,
    val date_first_listed: String,
    val date_updated: String,
    val description: String,
    val display_price: String,
    val currency: String,
    val location: Location,
    val owner: Owner,
    val property_images: List<PropertyImage>,
    val agent: Agent,
    val property_type: String,
    val sale_type: String,
)