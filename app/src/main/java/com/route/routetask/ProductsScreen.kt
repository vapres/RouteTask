package com.route.routetask

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.route.routetask.widget.ProductCard

@Composable
fun ProductsScreen() {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        items(productList.size) { product ->
            ProductCard(productList[product])

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowProductsScreen() {
    ProductsScreen()
}