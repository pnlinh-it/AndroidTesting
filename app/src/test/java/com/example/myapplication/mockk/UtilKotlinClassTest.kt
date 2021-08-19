package com.example.myapplication.mockk

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import org.junit.Test

// https://medium.com/joe-tsai/mockk-%E4%B8%80%E6%AC%BE%E5%BC%B7%E5%A4%A7%E7%9A%84-kotlin-mocking-library-part-4-4-f82443848a3a
class UtilKotlinClassTest {
    private val util = Util()
    // companion object     -> mock object
    // object
    //      @JvmStatic      -> mockStatic
    //      none            -> mockObject

    val testObject = mockk<TestUtils>()

    @Test
    fun test() {
        mockkObject(UtilKotlinClass)

        every { UtilKotlinClass.ok() } returns "okkk"
        every { UtilKotlinClass.okJvmStatic() } returns "okkkttt"

        println(UtilKotlinClass.ok())
        println(UtilKotlinClass.okJvmStatic())
    }
}
