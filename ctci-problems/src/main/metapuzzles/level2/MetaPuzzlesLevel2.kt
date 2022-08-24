package metapuzzles.level2

import java.util.Arrays
import kotlin.math.pow

// Hop
fun getSecondsRequired(N: Long, F: Int, P: Array<Long>): Long {
    Arrays.sort(P)
    var leadFrog = P[F - 1]
    var i = F - 2
    var totalHops = 0L
    while (i >= 0) { // move all the frogs so they are direct neighbors
        val hops = leadFrog - P[i] - 1
        totalHops += hops
        P[i] = P[i] + hops
        leadFrog = P[i]
        i--
    }
    var leadingPads = N - P[F - 1]
    //i = 0
    while (leadingPads > 1) { // frogs at rear leap frog over leader until leader is next to Pad N
        //P[i] = P.last() + 1
        leadingPads--
        //i++
        totalHops++
    }
    totalHops += F // leap frog over all the frogs landing on Pad N
    return totalHops
}

// Missing Mail
fun getMaxExpectedProfit(N: Int, V: Array<Int>, C: Int, S: Double): Double {
    return getProfitInRange(1, 5, V, C, S)
}

// Missing Mail helper function
fun getProfitInRange(start: Int, end: Int, V: Array<Int>, C: Int, S: Double):Double {
    var sum = (V.sum() - (2 * C)) * (1-S).pow(end - start - 1)
    var i = 1
    var exp = 2
    while (i <= (end - start - 1)) {
        var intermediateSum = 0.0
        intermediateSum += V[start - 1]
        intermediateSum += V[end - 1]
        var j = i + 1
        while (j <= (end - start - 1)) {
            intermediateSum += V[j]
            j++
        }
        intermediateSum -= (2 * C)
        intermediateSum *= (S * (1 - S).pow(exp))
        sum += intermediateSum
        i++
        exp--
    }
    return sum
}