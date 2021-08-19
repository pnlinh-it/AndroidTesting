package com.example.myapplication.about_argument_capture

import com.example.myapplication.mockk.SystemClass
import io.mockk.CapturingSlot
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.just
import io.mockk.mockkConstructor
import io.mockk.runs
import io.mockk.slot
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import java.util.Date

class KidTest {

    @MockK(relaxed = true)
    private lateinit var mother: Mother
    private val slot: CapturingSlot<Int> = slot()

    private lateinit var kid: Kid

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        kid = spyk(Kid())
    }

    // https://medium.com/joe-tsai/mockk-%E4%B8%80%E6%AC%BE%E5%BC%B7%E5%A4%A7%E7%9A%84-kotlin-mocking-library-part-3-4-79b40fb73964
    // https://medium.com/joe-tsai/mockk-%E4%B8%80%E6%AC%BE%E5%BC%B7%E5%A4%A7%E7%9A%84-kotlin-mocking-library-part-2-4-4be059331110
    // We don't know how many kid want to,
    // we need to get parameter pass to mother.inform
    // To archive this we use capture
    @Test
    fun wantMoney() {
        // every { mother.inform(capture(slot)) }
        mockkConstructor(Mother::class)
        val childCallback: CapturingSlot<(Boolean) -> Unit> = slot()
        every { anyConstructed<Mother>().inform(capture(slot), capture(childCallback)) }  just runs

        kid.wantMoney()
        //verify { mother.inform(capture(slot), capture(childCallback)) }

        childCallback.captured(false)
        verify { kid.doOnNotOK() }
        verify(exactly = 0) { kid.doOnOK() }

        childCallback.captured(true)
        verify { kid.doOnOK() }
        verify(exactly = 1) { kid.doOnNotOK() }

        println(slot.captured)
    }

    // Neu khong co relaxUnitFun thi verify { mother.testRelaxedMock(capture(slot)) } throw Exception
    // relaxUnitFun co tac dung voi verify
    @Test
    fun testRelaxedMock() {
        kid.testRelaxedMock()
        verify { mother.testRelaxedMock() }
    }

    @Test
    fun testSystem() {
        mockkConstructor(Date::class)

        every { anyConstructed<Date>().time } returns 1000

        val date = SystemClass().getDate()

        println(date)
    }
}
