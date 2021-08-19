package com.example.myapplication

class TestSpyUsingSystemStaticClass {
    fun getCurrentTime(): Long {
        val count = calculator(1, 2)
        return count + System.currentTimeMillis()
    }

    fun calculator(a: Int, b: Int) = a + b
}
