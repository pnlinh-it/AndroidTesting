package com.example.myapplication

import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class InjectMockTest {

    /**
     * Because this class use RobolectricTestRunner as runner, all fields annotate with @Mock  will not automatic mocked (null)
     * We need to use MockitoRule or add MockitoAnnotations.initMocks(this) on [setup]
     */
    @Rule
    @JvmField
    var rule: MockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var wordMap: List<String>

    @Before
    fun setup() {
        print("awdaw")
    }

    @Test
    fun whenUseInjectMocksAnnotation_thenCorrect() {
        Assert.assertEquals("aMeaning", "injectMock.getMeaning()")
    }
}
