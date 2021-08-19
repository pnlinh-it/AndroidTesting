package com.example.myapplication

import io.mockk.every
import io.mockk.mockkConstructor
import org.junit.Test

class TConstructorTest {

    @Test
    fun testSayHello() {
        mockkConstructor(Student::class)
        every { anyConstructed<Student>().sayHello() } returns "hello-world"

        TConstructor().sayHello()
    }
}
