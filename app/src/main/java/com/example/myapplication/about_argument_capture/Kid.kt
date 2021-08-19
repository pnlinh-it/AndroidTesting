package com.example.myapplication.about_argument_capture

import kotlin.random.Random

class Kid(/*private val mother: Mother*/) {
    private var money: Int = Random.nextInt(1, 100)

    fun wantMoney() {
        println(money)

        val action: (Boolean) -> Unit = { isOK ->
            if (isOK) doOnOK() else doOnNotOK()
        }

        Mother().inform(money, action)
    }

    fun doOnOK() {
        println("Ahh ok")
    }

    fun doOnNotOK() {
        println("Ahh nok")
    }

    fun testRelaxedMock() {
        // println(mother.testRelaxedMock())
    }
}
