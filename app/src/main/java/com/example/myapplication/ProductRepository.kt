package com.example.myapplication

class ProductRepository {
  companion object{
      private  val DATA : String  by lazy { "" }
  }
    fun getProductName() = "ProductRepository"
}
