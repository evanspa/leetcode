package metapuzzles.level1

import metapuzzles.level1.getMinProblemCount
import kotlin.test.Test
import kotlin.test.assertEquals

class GetMinProblemCountTest {

    @Test
    fun getMinProblemCountTest() {
        assertEquals(4, getMinProblemCount(arrayOf(1, 2, 3, 4, 5, 6)))
        assertEquals(3, getMinProblemCount(arrayOf(4, 3, 3, 4)))
        assertEquals(4, getMinProblemCount(arrayOf(2, 4, 6, 8)))
    }
}