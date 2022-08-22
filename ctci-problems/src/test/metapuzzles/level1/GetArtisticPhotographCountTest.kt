package metapuzzles.level1

import metapuzzles.level1.getArtisticPhotographCount
import kotlin.test.Test
import kotlin.test.assertEquals

class GetArtisticPhotographCountTest {

    @Test
    fun testGetArtisticPhotographCount() {
        assertEquals(1, getArtisticPhotographCount(5, "APABA", 1, 2))
        assertEquals(0, getArtisticPhotographCount(5, "APABA", 2, 3))
        assertEquals(3, getArtisticPhotographCount(8, ".PBAAP.B", 1, 3))
    }
}