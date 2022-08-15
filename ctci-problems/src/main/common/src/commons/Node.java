package commons;

// https://stackoverflow.com/q/21544716
public class Node<T extends Comparable<? super T>> implements Comparable<Node<T>> {

    public T value;
    public Status status;
    public Node<T> children[];

    @Override
    public int compareTo(Node<T> o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public final boolean equals(final Object o) {
        if (o instanceof Node<?>) {
            return this.value.equals(((Node<?>) o).value);
        }
        return false;
    }

    enum Status { Unvisited, Visited, Visiting }

    public Node(final T value) {
        this.value = value;
        this.status = Status.Unvisited;
    }
}
