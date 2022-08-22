package metapuzzles.level1

import metapuzzles.level1.getUniformIntegerCountInInterval
import metapuzzles.level1.uniformNumber
import kotlin.test.Test
import kotlin.test.assertEquals

class GetUniformIntegerCountInIntervalTest {

    @Test
    fun uniformNumberTest() {
        assertEquals(5555, uniformNumber('5', 4))
        assertEquals(77, uniformNumber('7', 2))
        assertEquals(33333, uniformNumber(32000.toString()[0], 5))
    }

    @Test
    fun getUniformIntegerCountInIntervalTest() {
        assertEquals(5, getUniformIntegerCountInInterval(75, 300))
        assertEquals(9, getUniformIntegerCountInInterval(1, 9))
        assertEquals(1, getUniformIntegerCountInInterval(999999999, 999999999))
        assertEquals(1, getUniformIntegerCountInInterval(1, 1))
        assertEquals(0, getUniformIntegerCountInInterval(41, 43))
        assertEquals(3, getUniformIntegerCountInInterval(1, 3))
        assertEquals(1, getUniformIntegerCountInInterval(3, 3))
        assertEquals(3 + (9 * 2) + 5, getUniformIntegerCountInInterval(75, 65000))
        assertEquals(2 + (9 * 2) + 5, getUniformIntegerCountInInterval(78, 65000))
        assertEquals(9 + (9 * 11) + 0, getUniformIntegerCountInInterval(1, 1_000_000_000_000))
        assertEquals(0, getUniformIntegerCountInInterval(65000, 65000))
        assertEquals(9 + (9 * 1) + 1, getUniformIntegerCountInInterval(1, 130))
        assertEquals(1, getUniformIntegerCountInInterval(9, 10))
        assertEquals(1, getUniformIntegerCountInInterval(99, 100))
        assertEquals(1, getUniformIntegerCountInInterval(999, 1_000))
        assertEquals(1 + (9 * 1) + 0, getUniformIntegerCountInInterval(9_999, 100_000))
        assertEquals(1 + (9 * 2) + 0, getUniformIntegerCountInInterval(9_999_999_999, 1_000_000_000_000))
        assertEquals(1, getUniformIntegerCountInInterval(444, 444))
        assertEquals(0, getUniformIntegerCountInInterval(422, 422))
        assertEquals(1, getUniformIntegerCountInInterval(320, 422))
        assertEquals(0, getUniformIntegerCountInInterval(393, 422))
        assertEquals(2, getUniformIntegerCountInInterval(320, 468))
    }
}