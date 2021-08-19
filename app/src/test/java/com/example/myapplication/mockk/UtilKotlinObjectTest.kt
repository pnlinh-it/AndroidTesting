package com.example.myapplication.mockk

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.mockkStatic
import org.junit.Test

internal class UtilKotlinObjectTest {
    @Test
    fun test() {
        mockkStatic(UtilKotlinObject::class)
        mockkObject(UtilKotlinObject)

        every { UtilKotlinObject.ok() } returns "ookokoko"
        every { UtilKotlinObject.okJvmStatic() } returns "ookokoko"

        println(UtilKotlinObject.ok())
        println(UtilKotlinObject.okJvmStatic())
    }
}
