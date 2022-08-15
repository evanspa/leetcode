package com.paulevans;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
//import org.j

public class Main {

    public static void main(String[] args) {
        /*System.out.printf("[%s] balanced? %b\n", "()", areParensBalanced("()"));
        System.out.printf("[%s] balanced? %b\n", "", areParensBalanced(""));
        System.out.printf("[%s] balanced? %b\n", "())", areParensBalanced("())"));
        System.out.printf("[%s] balanced? %b\n", "(()", areParensBalanced("(()"));
        System.out.printf("[%s] balanced? %b\n", "()()", areParensBalanced("()()"));
        System.out.printf("[%s] balanced? %b\n", "(((())())())", areParensBalanced("(((())())())"));
        System.out.printf("[%s] balanced? %b\n", "(((()))())", areParensBalanced("(((()))())"));

        System.out.printf("[%s] balanced2? %b\n", "()", areParensBalanced2("()"));
        System.out.printf("[%s] balanced2? %b\n", "", areParensBalanced2(""));
        System.out.printf("[%s] balanced2? %b\n", "())", areParensBalanced2("())"));
        System.out.printf("[%s] balanced2? %b\n", "(()", areParensBalanced2("(()"));
        System.out.printf("[%s] balanced2? %b\n", "()()", areParensBalanced2("()()"));
        System.out.printf("[%s] balanced2? %b\n", "(((())())())", areParensBalanced2("(((())())())"));
        System.out.printf("[%s] balanced2? %b\n", "(((()))())", areParensBalanced2("(((()))())"));*/

        TreeNode<Integer> node = new TreeNode<>(7);
        node.left = new TreeNode<>(2);
        node.left.left = new TreeNode<>(1);
        node.left.right = new TreeNode<>(3);
        node.right = new TreeNode<>(5);
        node.right.left = new TreeNode<>(4);
        node.right.right = new TreeNode<>(8);
        node.right.left.left = new TreeNode<>(0);

        List<TreeNode<Integer>> list = TreeNode.linearize_postOrder_1(node);
        for (TreeNode<Integer> n : list) {
            System.out.printf("%d, ", n.value);
        }
        System.out.printf("\n");

        list = TreeNode.linearize_postOrder_2(node);
        for (TreeNode<Integer> n : list) {
            System.out.printf("%d, ", n.value);
        }
        System.out.printf("\n");

        Map<Integer, Deque<Integer>> adjacencyList = new HashMap<>();
        Deque<Integer> children = new ArrayDeque<>();
        children.add(2); children.add(5);
        adjacencyList.put(7, children);
        children = new ArrayDeque<>();
        children.add(1); children.add(3);
        adjacencyList.put(2, children);
        children = new ArrayDeque<>();
        children.add(4); children.add(8);
        adjacencyList.put(5, children);
        //adjacencyList.put(1, new ArrayDeque<>());
        //adjacencyList.put(3, new ArrayDeque<>());
        children = new ArrayDeque<>();
        children.add(0);
        adjacencyList.put(4, children);
        //adjacencyList.put(0, new ArrayDeque<>());
        //adjacencyList.put(8, new ArrayDeque<>());
        GraphUtils.postOrderTraverse(adjacencyList, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.printf("%d, ", integer);
            }
        });
        System.out.printf("\n");
    }

    private static class Pair<T,K> {
        public final T t;
        public final K k;
        public Pair(T t, K k) {
            this.t = t;
            this.k = k;
        }
    }

    public static boolean areParensBalanced(final String s) {
        if (s.length() == 0) return true;
        final Deque<Character> chars = new ArrayDeque<>();
        final char sChars[] = s.toCharArray();
        for (char c : sChars) {
            if (c == '(') {
                chars.addFirst(c);
            } else if (c == ')') {
                if (chars.isEmpty()) {
                    return false;
                }
                chars.removeFirst();
            }
        }
        return chars.size() == 0;
    }

    public static boolean areParensBalanced2(final String s) {
        if (s.length() == 0) return true;
        int openParenCount = 0;
        final char sChars[] = s.toCharArray();
        for (char c : sChars) {
            if (c == '(') {
                openParenCount++;
            } else if (c == ')') {
                if (openParenCount == 0) {
                    return false;
                }
                openParenCount--;
            }
        }
        return openParenCount == 0;
    }
}
