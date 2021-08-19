package com.example.myapplication;

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(System::class)
class FeedRepositoryTest {

    @Test
    fun testGetFeed() {
        // mockkStatic(System::class)

        PowerMockito.`when`(System.currentTimeMillis()).thenReturn(-1)
        val feedRepository = FeedRepository()
        //
        // every { System.currentTimeMillis() } returns -1L

        Assert.assertEquals(feedRepository.feed.size, 1)

    }
}
