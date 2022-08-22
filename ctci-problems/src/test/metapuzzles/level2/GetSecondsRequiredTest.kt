package metapuzzles.level2

import kotlin.test.Test
import kotlin.test.assertEquals

class GetSecondsRequiredTest {

    @Test
    fun getSecondsRequiredTest() {
        assertEquals(2, getSecondsRequired(3, 1, arrayOf(1)))
        assertEquals(4, getSecondsRequired(6, 3, arrayOf(5, 2, 4)))
        assertEquals(17, getSecondsRequired(12, 5, arrayOf(2, 4, 6, 7, 10)))
    }
}