package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeNode<T extends Comparable<? super T>> implements Comparable<TreeNode<T>> {

    public TreeNode left;
    public TreeNode right;
    public T value;

    private static <T extends Comparable<? super T>> void createBinaryTree(TreeNode<T> node, int level, int numLevels) {
        if (level <= numLevels) {
            node.left = new TreeNode<>(null);
            node.right = new TreeNode<>(null);
            createBinaryTree(node.left, level + 1, numLevels);
            createBinaryTree(node.right, level + 1, numLevels);
        }
    }

    public static <T extends Comparable<? super T>> TreeNode<T> toTree_better(final T[] nodeItems) {
        if (nodeItems == null || nodeItems.length == 0) {
            return null;
        }
        final Deque<TreeNode<T>> queue = new ArrayDeque<>();
        final TreeNode<T> root = new TreeNode<>(nodeItems[0]);
        int count = nodeItems.length - 1;
        int itemIndex = 1;
        queue.addLast(root);
        while (count > 0) {
            final TreeNode<T> node = queue.removeFirst();
            node.left = new TreeNode<>(nodeItems[itemIndex]);
            queue.addLast(node.left);
            itemIndex++;
            count--;
            if (count - 1 > 0) {
                node.right = new TreeNode<>(nodeItems[itemIndex]);
                queue.addLast(node.right);
                itemIndex++;
                count--;
            }
        }
        return root;
    }

    public static <T extends Comparable<? super T>> TreeNode<T> toTree(final T[] nodeItems) {
        if (nodeItems == null || nodeItems.length == 0) {
            return null;
        }
        final TreeNode<T> root = new TreeNode<>(null);
        final int numLevels = (int) Math.ceil(Math.sqrt(nodeItems.length + 1));
        createBinaryTree(root, 1, numLevels - 1);
        final Deque<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.removeFirst();
            node.value = nodeItems[i];
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
            i++;
        }
        return root;
    }

    public TreeNode() {
        this (null);
    }

    public TreeNode(final T value) {
        this (null, null, value);
    }

    public TreeNode(final TreeNode<T> left, final TreeNode<T> right, final T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        return this.value.compareTo(o.value);
    }

    @Override
    public final boolean equals(final Object o) {
        if (o instanceof TreeNode<?>) {
            return this.value.equals(((TreeNode<?>) o).value);
        }
        return false;
    }

    public <T extends Comparable<? super T>> T[] bfsFlatten(TreeNode<T> root) {
        final Deque<TreeNode<T>> queue = new ArrayDeque<>();
        final List<T> array = new ArrayList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.removeFirst();
            array.add(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return (T[]) array.toArray();
    }

    @Override
    public final String toString() {
        return String.format("node value: %s", value);
    }
}
