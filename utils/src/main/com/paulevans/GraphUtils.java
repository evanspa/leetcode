package com.paulevans;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public final class GraphUtils {

    private static <T extends Comparable<? super T>> T removeNeighbor(final T node, final Map<T, Deque<T>> adjacencyList) {
        if (adjacencyList.containsKey(node)) {
            Deque<T> neighbors = adjacencyList.get(node);
            if (neighbors.isEmpty()) {
                return null;
            }
            T neighbor = neighbors.removeFirst();
            return neighbor;
        }
        return null;
    }

    public static <T extends Comparable<? super T>> void postOrderTraverse(Map<T, Deque<T>> adjacencyList, Consumer<T> consumer) {
        Deque<T> stack = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();
        Set<T> nodes = adjacencyList.keySet();
        for (T node : nodes) {
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.addFirst(node);
                    node = removeNeighbor(node, adjacencyList);
                } else {
                    T peekNode = stack.peekFirst();
                    T nextNeighbor = removeNeighbor(peekNode, adjacencyList);
                    if (nextNeighbor != null && !visited.contains(nextNeighbor)) {
                        node = nextNeighbor;
                    } else {
                        // --- VISIT NODE PORTION
                        if (!visited.contains(peekNode)) {
                            consumer.accept(peekNode);
                        }
                        // --- END VISIT NODE PORTION
                        visited.add(stack.removeFirst());
                    }
                }
            }
        }
    }
}
