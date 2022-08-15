package commons;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Utils {

    public static <T extends Comparable<? super T>> boolean isPresent(final Node<T> root, final Node<T> node) {
        if (root == null) return false;
        final Deque<Node<T>> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            final Node<T> d = nodes.remove();
            d.status = Node.Status.Visiting;
            if (node.equals(d)) {
                return true;
            }
            for (Node<T> child : d.children) {
                if (child.status == Node.Status.Unvisited) {
                    nodes.add(child);
                }
            }
        }
        return false;
    }
}
