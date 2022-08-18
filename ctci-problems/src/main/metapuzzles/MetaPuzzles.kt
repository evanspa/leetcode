package metapuzzles

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
    val unavail:MutableMap<Long, Long> = HashMap()
    for (s in S) {
        for (i in s-K..s+K) {
            unavail[i] = i
        }
    }
    var current = 1L
    var addl = 0L
    while (current <= N) {
        if (unavail.containsKey(current)) {
            current++
        } else {
            addl++
            current += (K + 1)
        }
    }
    return addl
}