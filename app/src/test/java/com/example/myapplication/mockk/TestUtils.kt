package com.example.myapplication.mockk

import com.example.myapplication.TestUtils
import com.example.myapplication.Utils
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Test

class TestUtils {
    @Test
    fun test() {
        mockkStatic(Utils::class)
        every { Utils.print(any()) } returns false
        TestUtils().callStatic()
        verify(exactly = 1) { Utils.print(any()) }
    }
}
