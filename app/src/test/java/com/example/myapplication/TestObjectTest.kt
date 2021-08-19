package com.example.myapplication

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.Test

internal class TestObjectTest {

    @Test
    fun test() {

        val student = mockk<Student>()
        every { student.sayHello() } returns ""
        mockkStatic(TestObject::class)
        every { TestObject.getCurrentTime() } returns 1
        val time = TestObject.getCurrentTime()
        println(time)
    }
}
