package com.example.myapplication.mockk

class ClassExtension {
    fun String.concat(other: String) = this + other

    fun test() {
        println("1".concat("2"))
    }
}
