import ctciproblems.Graph
import ctciproblems.Node
import ctciproblems.isRoute
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class RouteBetweenNodesTest {

    @Test
    fun testIsRoute() {
        // a graph with 1 node has a route from the node to itself
        var n1 = Node(1, false, mutableListOf())
        var graph = Graph(listOf(n1))
        assertTrue(isRoute(graph, n1, n1))

        // a graph with 2 disconnected nodes does not have a route
        n1 = Node(1, false, mutableListOf())
        var n2 = Node(2, false, mutableListOf())
        graph = Graph(listOf(n1, n2))
        assertFalse(isRoute(graph, n1, n2))

        // a graph with 2 connected nodes does have a route
        n2 = Node(2, false, mutableListOf())
        n1 = Node(1, false, mutableListOf(n2))
        graph = Graph(listOf(n1, n2))
        assertTrue(isRoute(graph, n1, n2))

        // connected graph w/nodes 1-9 (from Abdul Bari disjoint set vid)
        val a1 = Node(1, false, mutableListOf())
        val a2 = Node(2, false, mutableListOf())
        val a3 = Node(3, false, mutableListOf())
        val a4 = Node(4, false, mutableListOf())
        val a5 = Node(5, false, mutableListOf())
        val a6 = Node(6, false, mutableListOf())
        val a7 = Node(7, false, mutableListOf())
        val a8 = Node(8, false, mutableListOf())
        a1.neighbors.add(a2)
        a1.neighbors.add(a3)
        a2.neighbors.add(a1)
        a2.neighbors.add(a4)
        a2.neighbors.add(a5)
        a3.neighbors.add(a1)
        a3.neighbors.add(a4)
        a4.neighbors.add(a2)
        a4.neighbors.add(a3)
        a5.neighbors.add(a2)
        a5.neighbors.add(a5)
        a5.neighbors.add(a6)
        a6.neighbors.add(a5)
        a6.neighbors.add(a8)
        a7.neighbors.add(a5)
        a7.neighbors.add(a8)
        a8.neighbors.add(a6)
        a8.neighbors.add(a7)
        graph = Graph(listOf(a1, a2, a3, a4, a5, a6, a7, a8))
        assertTrue(isRoute(graph, a1, a8))
    }
}