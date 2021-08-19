package com.example.myapplication.mockk

import com.example.myapplication.ArgumentCapture
import com.example.myapplication.ArgumentService
import com.example.myapplication.Callback
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class ArgumentCaptureMockkTest {

    @MockK(relaxUnitFun = true)
    private lateinit var argumentService: ArgumentService

    val argumentCapture2 = mockk<ArgumentCapture>()

    val slot = slot<Callback>()

    private lateinit var argumentCapture: ArgumentCapture

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        argumentCapture = spyk(ArgumentCapture(argumentService))
    }

    @Test
    fun test() {
        every { argumentService.fetchData(capture(slot)) } answers {
            slot.captured.onResponse("dog")
        }

        argumentCapture.getData()

        verify { argumentService.fetchData(any()) }
        verify { argumentCapture.dog() }
    }

    @Test
    fun test1() {
        // every { argumentService.fetchData(capture(slot)) }
        argumentCapture.getData()
        verify { argumentService.fetchData(capture(slot)) }
        slot.captured.onResponse("dog")
        verify { argumentCapture.dog() }
    }
}
