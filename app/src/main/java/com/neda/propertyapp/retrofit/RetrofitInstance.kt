package com.neda.propertyapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val builder : Retrofit = Retrofit.Builder()
        .baseUrl("https://f213b61d-6411-4018-a178-53863ed9f8ec.mock.pstmn.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : RetrofitAPI = builder.create(RetrofitAPI::class.java)
}