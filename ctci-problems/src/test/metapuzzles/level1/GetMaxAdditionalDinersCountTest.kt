package metapuzzles.level1

import metapuzzles.level1.getMaxAdditionalDinersCount
import kotlin.test.Test
import kotlin.test.assertEquals

class GetMaxAdditionalDinersCountTest {

    @Test
    fun getMaxAdditionalDinersCountTest() {
        assertEquals(3, getMaxAdditionalDinersCount(10, 1, 2, arrayOf(2, 6)))
        assertEquals(1, getMaxAdditionalDinersCount(15, 2, 3, arrayOf(11, 6, 14)))
        assertEquals(0, getMaxAdditionalDinersCount(4, 0, 4, arrayOf(1, 2, 3, 4)))
        assertEquals(0, getMaxAdditionalDinersCount(0, 0, 0, arrayOf()))
        assertEquals(4, getMaxAdditionalDinersCount(4, 0, 0, arrayOf()))
    }
}