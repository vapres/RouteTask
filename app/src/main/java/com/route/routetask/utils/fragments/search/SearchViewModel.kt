package com.route.routetask.utils.fragments.search

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.routetask.model.Product
import com.route.routetask.model.ProductResponse
import com.route.routetask.model.api.ApiManager
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    var searchQuery by mutableStateOf("")
    var searchedProductsList by mutableStateOf(listOf<Product>())

    private var searchedProductResponse: ProductResponse? = null

    fun getProductBySearch() {

        viewModelScope.launch {
            try {
                searchedProductResponse =
                    ApiManager
                        .getProductsService()
                        .getSearchedProduct(search = searchQuery)
                if (!searchedProductResponse?.products.isNullOrEmpty()) {
                    searchedProductsList = searchedProductResponse!!.products
                }
            } catch (e: Exception) {
                Log.e(ContentValues.TAG, "Failed to fetch data: ${e.message}")

            }

        }
    }

}