package com.route.routetask.model.api

import com.route.routetask.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("products")

    fun getProducts(): Call<ProductResponse>

}