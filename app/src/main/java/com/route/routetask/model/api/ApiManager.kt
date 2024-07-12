package com.route.routetask.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiManager {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getProductsService(): ProductService {
        return retrofit.create(ProductService::class.java)
    }


}