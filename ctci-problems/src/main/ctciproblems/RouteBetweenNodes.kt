package ctciproblems

data class Node<T> (val value: T, var visited: Boolean = false, var neighbors: MutableList<Node<T>>)

data class Graph<T> (val nodes: List<Node<T>>)

fun <T> isRoute(graph: Graph<T>, start: Node<T>, end: Node<T>): Boolean {
    if (start == end) return true
    for (n in graph.nodes) {
        n.visited = false
    }
    val queue: ArrayDeque<Node<T>> = ArrayDeque()
    queue.addLast(start)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        node.visited = true
        if (node == end) {
            return true
        } else {
            for (n in node.neighbors) {
                if (!n.visited) {
                    queue.addLast(n)
                }
            }
        }
    }
    return false
}