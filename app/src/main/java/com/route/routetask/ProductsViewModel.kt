package com.route.routetask

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.route.routetask.model.Product
import com.route.routetask.model.ProductResponse
import com.route.routetask.model.api.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel : ViewModel() {
    var productsList by mutableStateOf(listOf<Product>())
    private var getProductsCall: Call<ProductResponse>? = null

    fun getProducts() {

        getProductsCall = ApiManager
            .getProductsService()
            .getProducts()

        getProductsCall?.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    val products = response.body()?.products
                    if (!products.isNullOrEmpty())
                        productsList = products
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e(ContentValues.TAG, "Failed to fetch data: ${t.message}")
            }

        })
    }
}