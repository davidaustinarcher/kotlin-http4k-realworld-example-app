package conduit

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class MockkFailingTest {
    @Test // fails
    fun `mockk test using any()`() {
        val mocked = mockk<TestMock>(relaxed = true)
        every { mocked.test(any()) } returns 1
    }

    @Test // passes
    fun `mockk test using hardcoded value`() {
        val mocked = mockk<TestMock>(relaxed = true)
        every { mocked.test(MyInlineType("123")) } returns 1
    }

}

inline class MyInlineType(val value: String)

interface TestMock {
    fun test(value: MyInlineType): Int
}
