package com.route.routetask.model.api

import com.route.routetask.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("products")

    suspend fun getAllProducts(): ProductResponse

    @GET("products/search")
    suspend fun getSearchedProduct(
        @Query("q") search: String
    ): ProductResponse

}