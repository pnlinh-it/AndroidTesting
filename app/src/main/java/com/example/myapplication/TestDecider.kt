package com.example.myapplication

import android.content.Context

class TestDecider(
    private val context: Context,
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository
) {
    fun shouldGo(): Boolean {
        if (isProduct()) return true
        return false
    }

    fun isProduct(): Boolean {
        return productRepository.getProductName() == "ProductRepository"
    }
}
