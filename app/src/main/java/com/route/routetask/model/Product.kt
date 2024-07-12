package com.route.routetask.model

data class Product(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: Double,
    val rating: Double,
    val thumbnail: String,
    val title: String,

)