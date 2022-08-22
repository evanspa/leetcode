package metapuzzles.level1

import metapuzzles.level1.getMinimumDeflatedDiscCount
import kotlin.test.Test
import kotlin.test.assertEquals

class GetMinimumDeflatedDiscCountTest {

    @Test
    fun getMinimumDeflatedDiscCountTest() {
        assertEquals(3, getMinimumDeflatedDiscCount(5, arrayOf(2, 5, 3, 6, 5)))
        assertEquals(2, getMinimumDeflatedDiscCount(3, arrayOf(100, 100, 100)))
        assertEquals(-1, getMinimumDeflatedDiscCount(4, arrayOf(6, 5, 4, 3)))
        assertEquals(0, getMinimumDeflatedDiscCount(4, arrayOf(1, 2, 3, 4)))
        assertEquals(0, getMinimumDeflatedDiscCount(4, arrayOf(4)))
    }
}