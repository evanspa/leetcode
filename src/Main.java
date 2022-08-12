import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import tree.TreeNode;

public final class Main {

    public static void main(final String[] args) {

        Integer[] treeNodeVals = new Integer[15];
        for (int i = 0; i < treeNodeVals.length; i++) {
            treeNodeVals[i] = i;
        }
        TreeNode<Integer> root = TreeNode.toTree_better(treeNodeVals);
        System.out.printf("root: %s\n", root);
        System.out.printf("root.left: %s\n", root.left.value);
        System.out.printf("root.right: %s\n", root.right.value);
        System.out.printf("root.left.left: %s\n", root.left.left.value);
        System.out.printf("root.left.right: %s\n", root.left.right.value);

        /*System.out.printf("max: %d\n", Integer.MAX_VALUE);
        System.out.printf("min: %d\n", Integer.MIN_VALUE);
        System.out.printf("max div 10: %d\n", Integer.MAX_VALUE % 10);
        System.out.printf("min div 10: %d\n", Integer.MIN_VALUE % 10);*/

        /*final List<Node<Animal>> nodes = new ArrayList<>();
        final Node<Animal> lionNode1 = new Node<>(new Animal("brown", "lion", 5));
        final Node<Animal> lionNode2 = new Node<>(new Animal("brown", "lion", 5));
        final Node<Animal> giraffeNode1 = new Node<>(new Animal("orange", "giraffe", 20));
        System.out.println(String.format("num odds: [%d]", countIf(Arrays.asList(0, 1, 2, 5, 7), n1 -> n1.intValue() % 2 != 0)));
        System.out.println(String.format("max: [%d]", findMax(Arrays.asList(7, 0, 2, 99, 82))));
        System.out.println(String.format("max: [%s]", findMax(Arrays.asList(new A(0), new B(8), new A(2)))));
        System.out.printf("gcd(%d, %d): %d\n", 8, 10, gcd(8, 10));
        System.out.printf("gcd(%d, %d): %d\n", 1701, 3768, gcd(1701, 3768));
        System.out.printf("gcd(%d, %d): %d\n", 3768, 1701, gcd(3768, 1701));
        int items[] = new int[] { 0, 0, 0, 4, 5, 6 };
        moveZerosRecursive(items);
        printArray(items);
        items = new int[] { 0, 1, 0, 2, 0, 7 };
        moveZerosRecursive(items);
        printArray(items);*/

        /*ListNode<String> s1 = new ListNode<>("w");
        s1.next = new ListNode<>("");
        s1.next.next = new ListNode<>("orl");
        s1.next.next.next = new ListNode<>("d");
        ListNode<String> s2 = new ListNode<>("worl");
        s2.next = new ListNode<>("");
        s2.next.next = new ListNode<>("");
        s2.next.next.next = new ListNode<>("");
        s2.next.next.next.next = new ListNode<>("d");
        s2.next.next.next.next.next = new ListNode<>("");
        System.out.printf("lexiEqual?: %b\n", ListNode.isLexigraphicallyEqual(s1, s2));*/

        System.out.printf("add(%d, %d): %d, expected: %d\n", 1492, 18, add(1492, 18), 1492 + 18);
    }

    static int add(int a, int b) {
        while (b != 0) {
            int sumWithoutCarry = a ^ b;
            int carry = (a & b) << 1;
            a = sumWithoutCarry;
            b = carry;
        }
        return a;
    }

    public static int gcd(int x, int y) {
        int r = x % y;
        while (r != 0) {
            x = y;
            y = r;
            r = x % y;
        }
        return y;
    }

    static class A implements Comparable<A> {
        public int val;
        public A(int v) { val = v; }
        public String toString() { return "val_" + val; }
        public int compareTo(A a) {
            return Integer.compare(this.val, a.val);
        }
    }
    static class B extends A { public B(int v) { super(v); }}

    public static <T extends Comparable<? super T>> T findMax(List<? extends T> items) {
        T max = items.get(0);
        for (int i = 1; i < items.size(); i++) {
            T item = items.get(i);
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static <T> int countIf(final Collection<T> items, Predicate<T> test) {
        int count = 0;
        for (T item : items) {
            if (test.test(item)) {
                count++;
            }
        }
        return count;
    }

    public static <T> void swap(T[] items, int i, int j) {
        T item = items[i];
        items[i] = items[j];
        items[j] = item;
    }

    public static <T> void swap(int[] items, int i, int j) {
        int item = items[i];
        items[i] = items[j];
        items[j] = item;
    }

    public static void printArray(final int items[]) {
        final StringBuilder sb = new StringBuilder("[ ");
        for (int i : items) {
            sb.append(i).append(" ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void moveZeros(final int items[]) {
        if (items.length <= 1) {
            return;
        }
        int i = 0;
        int j = items.length - 1;
        while (i < j) {
            if (items[i] == 0) {
                swap(items, i, j);
                j--;
            } else {
                i++;
            }
        }
    }

    public static void moveZerosRecursive(final int items[]) {
        if (items.length <= 1) {
            return;
        }
        moveZerosRecursiveSupport(items, 0, items.length - 1);
    }

    private static void moveZerosRecursiveSupport(final int items[], final int i, final int j) {
        if (i < j) {
            if (items[i] == 0) {
                swap(items, i, j);
                moveZerosRecursiveSupport(items, i, j - 1);
            } else {
                moveZerosRecursiveSupport(items, i + 1, j);
            }
        }
    }
}
