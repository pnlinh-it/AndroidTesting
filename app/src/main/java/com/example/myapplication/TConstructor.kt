package com.example.myapplication

class TConstructor {
    private val student: Student = Student()

    fun sayHello() {
        println(student.sayHello())
    }
}

class Student {
    fun sayHello() = "hello"
}

