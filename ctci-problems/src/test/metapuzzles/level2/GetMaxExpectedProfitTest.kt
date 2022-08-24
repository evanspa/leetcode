package metapuzzles.level2

import kotlin.test.Test
import kotlin.test.assertEquals

class GetMaxExpectedProfitTest {

    @Test
    fun getMaxExpectedProfitTest() {
        assertEquals(20.10825, getMaxExpectedProfit(5, arrayOf(10, 2, 8, 6, 4), 3, .15))
    }
}