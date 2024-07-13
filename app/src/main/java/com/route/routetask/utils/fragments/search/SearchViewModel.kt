package com.route.routetask.utils.fragments.search

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

class SearchViewModel : ViewModel() {
    var searchQuery by mutableStateOf("")
    var searchedProductsList by mutableStateOf(listOf<Product>())

    private var getSearchedProductCall: Call<ProductResponse>? = null

    fun getProductBySearch() {

        getSearchedProductCall =
            ApiManager
                .getProductsService()
                .getSearchedProduct(search = searchQuery)

        getSearchedProductCall?.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    val searchedProducts = response.body()?.products
                    if (!searchedProducts.isNullOrEmpty())
                        searchedProductsList = searchedProducts
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e(ContentValues.TAG, "Searched product not found ${t.message}")
            }

        })
    }

}