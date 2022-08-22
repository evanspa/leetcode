package metapuzzles.level1

import metapuzzles.level1.getMaximumEatenDishCount
import kotlin.test.Test
import kotlin.test.assertEquals

class GetMaximumEastenDishCountTest {

    @Test
    fun getMaximumEatenDishCountTest() {
        assertEquals(5, getMaximumEatenDishCount(6, arrayOf(1, 2, 3, 3, 2, 1), 1))
        assertEquals(4, getMaximumEatenDishCount(6, arrayOf(1, 2, 3, 3, 2, 1), 2))
        assertEquals(2, getMaximumEatenDishCount(7, arrayOf(1, 2, 1, 2, 1, 2, 1), 2))
    }
}