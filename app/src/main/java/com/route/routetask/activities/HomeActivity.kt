package com.route.routetask.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.route.routetask.ui.theme.RouteTaskTheme
import com.route.routetask.utils.fragments.products.ProductsScreen
import com.route.routetask.utils.fragments.search.SearchScreen
import android.graphics.Color

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RouteTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductsActivity()
                }
            }
        }
    }
}

@Composable
fun ProductsActivity() {
    val navController = rememberNavController()

    NavHost(
        startDestination = "products",
        navController = navController
    ) {
        composable(route = "products") {
            ProductsScreen() {
                navController.navigate("search")
            }
        }

        composable(route = "search") {
            SearchScreen()
        }
    }

}
