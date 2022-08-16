package makebinarysearchtree

data class Node<T>(var value: T, var left: Node<T>? = null, var right: Node<T>? = null)

private fun <T> makeBSTHelper(items: List<T>, start: Int, end: Int): Node<T>? {
    if (start <= end) {
        val mid = (start + end) / 2
        val node = Node(items[mid])
        node.left = makeBSTHelper(items, start, mid - 1)
        node.right = makeBSTHelper(items, mid + 1, end)
        return node
    }
    return null
}

fun <T> makeBinarySearchTree(items: List<T>): Node<T>? =
    if (items.isNotEmpty()) makeBSTHelper(items, 0, items.size - 1) else null
