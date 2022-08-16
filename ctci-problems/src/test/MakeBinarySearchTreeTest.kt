import makebinarysearchtree.Node
import makebinarysearchtree.makeBinarySearchTree
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class MakeBinarySearchTreeTest {

    @Test
    fun testMakeBinarySearchTree() {
        val root: Node<Int>? = makeBinarySearchTree(listOf(1, 2, 3, 4, 5, 6, 7))
        assertNotNull(root)
        assertEquals(4, root.value)
        assertEquals(2, root.left?.value)
        assertEquals(6, root.right?.value)
        assertEquals(1, root.left?.left?.value)
        assertEquals(3, root.left?.right?.value)
        assertEquals(5, root.right?.left?.value)
        assertEquals(7, root.right?.right?.value)
    }
}