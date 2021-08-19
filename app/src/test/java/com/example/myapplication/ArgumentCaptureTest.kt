package com.example.myapplication

import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class ArgumentCaptureTest {

    @Mock
    lateinit var argumentService: ArgumentService

    @Captor
    lateinit var argCaptor: ArgumentCaptor<Callback>

    lateinit var argumentCapture: ArgumentCapture

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        argumentCapture = Mockito.spy(ArgumentCapture(argumentService))
    }

    // https://stackoverflow.com/a/52674540
    @Test
    fun getData() {
        val a: String = mockk()

        argumentCapture.getData()

        Mockito.verify(argumentService).fetchData(argCaptor.capture())

        argCaptor.value.onResponse("dog")
        Mockito.verify(argumentCapture).dog()
        Mockito.verify(argumentCapture).dog()
    }
}
