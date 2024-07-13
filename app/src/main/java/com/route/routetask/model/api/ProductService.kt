package com.route.routetask.model.api

import com.route.routetask.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("products")

    fun getAllProducts(): Call<ProductResponse>

    @GET("products/search")
    fun getSearchedProduct(
        @Query("q") search: String
    ): Call<ProductResponse>

}