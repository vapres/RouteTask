package com.route.routetask

import android.widget.RemoteViews.RemoteView

data class Product(
    val titleResId: Int,
    val drawableResId: Int,
    val reviewRate: Double,
    val originalPrice: String,
    val priceAfterDiscount: String
)

val productList = listOf<Product>(
    Product(
        R.string.product_title,
        R.drawable.sneakers,
        4.3,
        "2000",
        "1200"
    ),
    Product(
        R.string.product_title,
        R.drawable.sneakers_2,
        4.4,
        "2000",
        "1200"
    ),
    Product(
        R.string.product_title,
        R.drawable.sneakers_3,
        4.6,
        "2000",
        "1200"
    ),
    Product(
        R.string.product_title,
        R.drawable.sneakers,
        4.3,
        "2000",
        "1200"
    ),
    Product(
        R.string.product_title,
        R.drawable.sneakers,
        4.3,
        "2000",
        "1200"
    ),
    Product(
        R.string.product_title,
        R.drawable.sneakers,
        4.3,
        "2000",
        "1200"
    ),
    Product(
        R.string.product_title,
        R.drawable.sneakers,
        4.3,
        "2000",
        "1200"
    ),
    Product(
        R.string.product_title,
        R.drawable.sneakers,
        4.3,
        "2000",
        "1200"
    ),
    Product(
        R.string.product_title,
        R.drawable.sneakers,
        4.3,
        "2000",
        "1200"
    ),
    Product(
        R.string.product_title,
        R.drawable.sneakers,
        4.3,
        "2000",
        "1200"
    )
)