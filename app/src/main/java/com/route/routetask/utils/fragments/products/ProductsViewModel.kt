package com.route.routetask.utils.fragments.products

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.routetask.model.Product
import com.route.routetask.model.ProductResponse
import com.route.routetask.model.api.ApiManager
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel : ViewModel() {
    var productsList by mutableStateOf(listOf<Product>())
    var focusRequester = FocusRequester()
    private var productResponse: ProductResponse? = null

    fun getProducts() {

        viewModelScope.launch {
            try {
                productResponse = ApiManager
                    .getProductsService()
                    .getAllProducts()

                if (!productResponse?.products.isNullOrEmpty()) {
                    productsList = productResponse!!.products
                }
            } catch (e: Exception) {
                Log.e(ContentValues.TAG, "Failed to fetch data: ${e.message}")
            }


        }
    }
}
