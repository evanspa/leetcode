package commons;

public class ListNode<T extends Comparable<? super T>> implements Comparable<ListNode<T>> {

    public T value;
    public ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
    }

    @Override
    public int compareTo(ListNode<T> o) {
        return this.value.compareTo(o.value);
    }

    public static boolean isLexigraphicallyEqual(ListNode<String> list1, ListNode<String> list2) {
        int s1Idx = 0;
        int s2Idx = 0;
        char[] s1 = list1.value.toCharArray();
        char[] s2 = list2.value.toCharArray();
        boolean equal = true;
        boolean keepGoing = true;
        int s1Length = s1.length;
        int s2Length = s2.length;
        int numComparisons = 0;
        while (equal && keepGoing) {
            while (s1.length == 0 || s1Idx == s1.length) {
                list1 = list1.next;
                if (list1 != null) {
                    s1 = list1.value.toCharArray();
                    s1Idx = 0;
                    s1Length += s1.length;
                } else {
                    keepGoing = false;
                    break;
                }
            }
            while (keepGoing && (s2.length == 0 || s2Idx == s2.length)) {
                list2 = list2.next;
                if (list2 != null) {
                    s2 = list2.value.toCharArray();
                    s2Length += s2.length;
                    s2Idx = 0;
                } else {
                    keepGoing = false;
                    break;
                }
            }
            while (keepGoing && (s1Idx < s1.length) && (s2Idx < s2.length) && equal) {
                equal = s1[s1Idx] == s2[s2Idx];
                if (equal) {
                    numComparisons++;
                    s1Idx++;
                    s2Idx++;
                } else {
                    return false;
                }
            }
        }
        return s1Length == s2Length && numComparisons == s1Length;
    }
}
