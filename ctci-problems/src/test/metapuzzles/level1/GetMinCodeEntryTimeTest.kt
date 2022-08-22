package metapuzzles.level1

import metapuzzles.level1.getMinCodeEntryTime
import kotlin.test.Test
import kotlin.test.assertEquals

class GetMinCodeEntryTimeTest {

    @Test
    fun testGetMinCodeEntryTime(): Unit {
        assertEquals(2, getMinCodeEntryTime(3, 3, arrayOf(1, 2, 3)))
        assertEquals(11, getMinCodeEntryTime(10, 4, arrayOf(9, 4, 4, 8)))
    }
}