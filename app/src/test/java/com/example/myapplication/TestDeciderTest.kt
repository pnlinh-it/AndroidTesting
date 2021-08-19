package com.example.myapplication

import android.content.Context
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class TestDeciderTest {

    @Rule
    @JvmField
    var rule: MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var userRepository: UserRepository

    @Mock
    private lateinit var productRepository: ProductRepository

    // https://stackoverflow.com/a/20270751
    // https://stackoverflow.com/a/16467893
    @InjectMocks
    private lateinit var testDeciderMock: TestDecider

    private lateinit var testDeciderSpy: TestDecider

    @Before
    fun setup() {
        // Don't need because we are using MockitoJUnit
        // MockitoAnnotations.initMocks(this)
        testDeciderSpy = Mockito.spy(TestDecider(context, userRepository, productRepository))
    }

    // https://stackoverflow.com/a/29394497  doReturn/when vs when/thenReturn

    @Test
    fun shouldGo_false() {

        Mockito.doReturn("InvalidName").`when`(productRepository).getProductName()
        Assert.assertEquals(testDeciderSpy.shouldGo(), false)

        Mockito.doReturn("ProductRepository").`when`(productRepository).getProductName()
        Assert.assertEquals(testDeciderSpy.shouldGo(), true)

        Mockito.doReturn(true).`when`(testDeciderSpy).isProduct()
        // Mockito.`when`(testDecider.isProduct()).thenReturn(true)  will throw exception
        Assert.assertEquals(testDeciderSpy.shouldGo(), true)

        Mockito.doReturn(false).`when`(testDeciderSpy).isProduct()
        // Mockito.`when`(testDecider.isProduct()).thenReturn(true)  will throw exception
        Assert.assertEquals(testDeciderSpy.shouldGo(), false)
    }
}
