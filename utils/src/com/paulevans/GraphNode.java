package com.paulevans;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T extends Comparable<? super T>> implements Comparable<GraphNode<T>> {

    public T value;
    public List<GraphNode<T>> neighbors;

    public GraphNode(T value) {
        this.value = value;
        neighbors = new ArrayList<>();
    }

    public void addNeighbor(GraphNode<T> node) {
        neighbors.add(node);
    }

    @Override
    public final int compareTo(final GraphNode<T> o) {
        return this.value.compareTo(o.value);
    }
}
