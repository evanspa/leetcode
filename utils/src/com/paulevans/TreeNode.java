package com.paulevans;

import java.util.*;

public class TreeNode<T extends Comparable<? super T>> implements Comparable<TreeNode<T>> {

    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    @Override
    public int compareTo(TreeNode<T> o) {
        return this.value.compareTo(o.value);
    }

    public TreeNode(T value) {
        this.value = value;
    }

    // found this one on leetcode and rewrote using generics.  This does the same thing as postOrder_1 below,
    // but uses more space in that a Set is used to keep track if a node has already been visited or not.
    public static <T extends Comparable<? super T>> List<TreeNode<T>> linearize_postOrder_2(TreeNode<T> node) {
        List<TreeNode<T>> linearOrder = new ArrayList<>();
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        Set<TreeNode<T>> visited = new HashSet<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode<T> peekNode = stack.peekFirst();
            if (peekNode.left != null && !visited.contains(peekNode.left)) {
                stack.addFirst(peekNode.left);
            } else if (peekNode.right != null && !visited.contains(peekNode.right)) {
                stack.addFirst(peekNode.right);
            } else {
                TreeNode<T> temp = stack.removeFirst();
                linearOrder.add(temp);
                visited.add(temp);
            }
        }
        return linearOrder;
    }

    public static <T extends Comparable<? super T>> List<TreeNode<T>> linearize_postOrder_1(TreeNode<T> node) {
        List<TreeNode<T>> linearOrder = new ArrayList<>();
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> lastVisitedNode = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.addFirst(node);
                node = node.left;
            } else {
                TreeNode<T> peekNode = stack.peekFirst();
                if (peekNode.right != null && peekNode.right != lastVisitedNode) {
                    node = peekNode.right;
                } else {
                    linearOrder.add(peekNode);
                    lastVisitedNode = stack.removeFirst();
                }
            }
        }
        return linearOrder;
    }
}
