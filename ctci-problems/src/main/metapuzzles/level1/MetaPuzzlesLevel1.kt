package metapuzzles.level1

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.log10

// (Level 1) Rotary Lock Puzzle, https://www.metacareers.com/profile/coding_puzzles/?puzzle=990060915068194
fun getMinCodeEntryTime(N: Int, M: Int, C: Array<Int>): Long {
    var totalTime = 0L
    var previous = 1
    for (c in C) {
        var left = 0
        var right = 0
        if (previous < c) {
            right = c - previous
            left = (N - c) + previous
        } else if (previous > c) {
            right = (N - previous) + c
            left = previous - c
        }
        previous = c
        totalTime += Math.min(left, right)
    }
    return totalTime
}

// (Level 1) Scoreboard Inference 1, https://www.metacareers.com/profile/coding_puzzles/?puzzle=348371419980095
fun getMinProblemCount(S: Array<Int>): Int {
    var maxTwos = 0
    var maxOnes = 0
    for (s in S) {
        maxTwos = Math.max(maxTwos, s / 2)
        maxOnes = Math.max(maxOnes, s % 2)
    }
    return maxTwos + maxOnes
}

// (Level 1) Cafeteria, https://www.metacareers.com/profile/coding_puzzles/?puzzle=203188678289677
fun getMaxAdditionalDinersCount(N: Long, K: Long, M: Int, S: Array<Long>): Long {
    Arrays.sort(S)
    var additional = 0L
    var start = 1L
    for (s in S) {
        val end = s - K
        if (start < end) {
            additional += Math.ceil((end - start).toDouble() / (K + 1)).toLong()
        }
        start = s + K + 1;
    }
    if (start < N) {
        additional += Math.ceil((N - start + 1).toDouble() / (K + 1)).toLong()
    }
    return additional
}

fun getArtisticPhotographCount(N: Int, C: String, X: Int, Y: Int): Int {
    return getArtisticPhotographCount(N, C, X, Y, "PAB") +
            getArtisticPhotographCount(N, C, X, Y, "BAP")
}

// This solution uses 3 sliding pointers (sliding window approach!).
fun getArtisticPhotographCount(N: Int, C: String, X: Int, Y: Int, seq: String): Int {
    var count = 0
    var p = 0
    while (p <= ((N - 3) - (2 * (X - 1)))) {
        if (C[p] != seq[0]) {
            p++
        } else {
            var a = p + X
            while ((a <= ((N - 2) - (X - 1))) && ((a >= (p + X)) && (a <= (p + Y)))) {
                if (C[a] != seq[1]) {
                    a++
                } else {
                    var b = a + X
                    while ((b < N) && ((b >= (a + X)) && (b <= (a + Y)))) {
                        if (C[b] != seq[2]) {
                            b++;
                        } else {
                            count++;
                            b++;
                        }
                    }
                    a++
                }
            }
            p++
        }
    }
    return count
}

fun getMaximumEatenDishCount(N: Int, D: Array<Int>, K: Int): Int {
    val lastEatenMap = HashMap<Int, Int>()
    var eaten = 0
    for (d in D) {
       val lastEaten = lastEatenMap[d]
       if (lastEaten == null) {
           eaten++
           lastEatenMap[d] = eaten
       } else {
           if ((eaten - lastEaten) >= K) {
               eaten++
               lastEatenMap[d] = eaten
           }
       }
    }
    return eaten
}

fun getMinimumDeflatedDiscCount(N: Int, R: Array<Int>): Int {
    if (R.last() < R.size) return -1
    var i = R.size - 2
    var deflations = 0
    while (i >= 0) {
        if (R[i] >= R[i + 1]) {
            R[i] = R[i + 1] - 1
            if (R[i] < 0) {
                return -1
            }
            deflations++
        }
        i--;
    }
    return deflations
}

fun uniformNumber(digit: Char, length: Int):Long {
    val num = CharArray(length)
    for (i in 0 until length) {
        num[i] = digit
    }
    return String(num).toLong()
}

fun getUniformIntegerCountInInterval(A: Long, B: Long): Int {
    if (B < 10) return ((B - A) + 1).toInt()
    val AStr = A.toString()
    val BStr = B.toString()
    val AMagnitude = log10(A.toDouble()).toInt() + 1
    val BMagnitude = log10(B.toDouble()).toInt() + 1
    val magDiff = BMagnitude - AMagnitude
    var uniformCount = 0
    if (magDiff == 0) {
        if (AStr[0] == BStr[0]) {
            if (B < uniformNumber(BStr[0], BMagnitude)) {
                return 0
            } else {
                return 1
            }
        }
        var minuend = Character.getNumericValue(BStr[0])
        if (B >= uniformNumber(BStr[0], BMagnitude)) {
            minuend++
        }
        var subtrahend = Character.getNumericValue(AStr[0])
        if (A > uniformNumber(AStr[0], AMagnitude)) {
            subtrahend++
        }
        return minuend - subtrahend
    }
    uniformCount += (10 - Character.getNumericValue(A.toString()[0]))
    if (A > uniformNumber(A.toString()[0], AMagnitude)) {
        uniformCount--
    }
    if (magDiff >= 2) {
        uniformCount += 9 * (magDiff - 1)
    }
    uniformCount += Character.getNumericValue(B.toString()[0])
    if (uniformNumber(B.toString()[0], BMagnitude) > B) {
        uniformCount--
    }
    return uniformCount
}
