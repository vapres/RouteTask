package com.route.routetask.utils.fragments.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.route.routetask.widget.ProductAppBar
import com.route.routetask.widget.ProductCard
import com.route.routetask.widget.ProductsList
import com.route.routetask.widget.SearchBar

@Composable
fun ProductsScreen(viewModel: ProductsViewModel = viewModel(), onBarClick: () -> Unit) {

    Scaffold(topBar = { ProductAppBar() }) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxSize()
        ) {

            SearchBar(onBarClick)

            viewModel.getProducts()
            ProductsList(viewModel.productsList)

        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShowProductsScreen() {
    ProductsScreen(viewModel(), {})
}