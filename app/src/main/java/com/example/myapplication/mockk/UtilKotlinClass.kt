package com.example.myapplication.mockk

class UtilKotlinClass {
    companion object {

        @JvmStatic
        fun okJvmStatic(): String {
            return "UtilKotlin.ok()"
        }

        fun ok(): String {
            return "UtilKotlin.ok()"
        }
    }
}
