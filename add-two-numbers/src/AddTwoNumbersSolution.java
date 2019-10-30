// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// Example:
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

class ListNode {
    final int val;
    ListNode next;
    ListNode(final int x) { this.val = x; }
}

public final class AddTwoNumbersSolution {

    private static int toInt(final ListNode node) {
        final StringBuilder sb = new StringBuilder();
        ListNode currentNode = node;
        while (currentNode != null) {
            sb.insert(0, currentNode.val);
            currentNode = currentNode.next;
        }
        return Integer.parseInt(sb.toString());
    }

    public final ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
        return toInt(l1) + toInt(l2);
    }
}
