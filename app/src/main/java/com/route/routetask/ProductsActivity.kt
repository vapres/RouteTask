package com.route.routetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.route.routetask.ui.theme.RouteTaskTheme
import com.route.routetask.widget.ProductCard

class ProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RouteTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductsScreen()
                }
            }
        }
    }
}

@Composable
fun ProductsScreen(viewModel: ProductsViewModel = viewModel()) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        viewModel.getProducts()
        items(viewModel.productsList.size) { product ->
            ProductCard(viewModel.productsList[product])

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowProductsScreen() {
    ProductsScreen()
}