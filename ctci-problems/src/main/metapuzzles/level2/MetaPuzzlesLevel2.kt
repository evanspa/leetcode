package metapuzzles.level2

import java.util.Arrays

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