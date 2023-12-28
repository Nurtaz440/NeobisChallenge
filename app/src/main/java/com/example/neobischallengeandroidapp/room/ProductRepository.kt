package com.example.neobischallengeandroidapp.room

import com.example.neobischallengeandroidapp.module.Product

class ProductRepository(private val productDao: ProductDao) {
    suspend fun insertProduct(product: Product) {
        productDao.insertProduct(product)
    }

    suspend fun getAllProducts(): List<Product> {
        return productDao.getAllProducts()
    }
}