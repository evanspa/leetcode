import metapuzzles.getMaxAdditionalDinersCount
import kotlin.test.Test
import kotlin.test.assertEquals

class GetMaxAdditionalDinersCountTest {

    @Test
    fun getMaxAdditionalDinersCountTest() {
        assertEquals(3, getMaxAdditionalDinersCount(10, 1, 2, arrayOf(2, 6)))
        assertEquals(1, getMaxAdditionalDinersCount(15, 2, 3, arrayOf(11, 6, 14)))
    }
}