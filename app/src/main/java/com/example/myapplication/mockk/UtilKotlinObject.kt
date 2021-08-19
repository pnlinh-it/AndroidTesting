package com.example.myapplication.mockk

object UtilKotlinObject {
    @JvmStatic
    fun okJvmStatic(): String {
        return "UtilKotlin.ok()"
    }

    fun ok(): String {
        return "UtilKotlin.ok()"
    }
}
