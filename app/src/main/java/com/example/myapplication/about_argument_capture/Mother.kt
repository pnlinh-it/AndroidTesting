package com.example.myapplication.about_argument_capture

class Mother {
    private val discount = 50

    fun inform(money: Int, action: (Boolean) -> Unit) {
        println("Child want to get $money")
        action(money >= discount)
    }

    fun testRelaxedMock() {
    }
}
