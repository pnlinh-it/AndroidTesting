package com.example.myapplication.mockk

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.Test

class TopLevelTest {

    @Test
    fun testTopLevel() {
        mockkStatic("com.example.myapplication.mockk.TopLevelKt")

        every { lowercase(any()) } returns "Mocked!"

        println(lowercase("Don't care"))
    }

    @Test
    fun testTopLevelExtension() {
        mockkStatic("com.example.myapplication.mockk.TopLevelExtensionKt")

        every { any<String>().concat(any()) } returns "Mocked!"
        every { "abc".concat("def") } returns "abc-and-def"

        println("Don't care".concat("plus me"))

        println("abc".concat("def"))
    }

    @Test
    fun testClassExtension() {
        val mock = mockk<ClassExtension>()
        with(mock) {
            every { any<String>().concat(any()) } returns "result"
        }
    }
}
