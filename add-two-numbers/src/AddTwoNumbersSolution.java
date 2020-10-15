// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// Example:
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

import java.math.BigInteger;

class ListNode {
    final int val;
    ListNode next;
    ListNode(final int x) { this.val = x; }
}

public final class AddTwoNumbersSolution {

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final BigInteger sum = toInt(l1).add(toInt(l2));
        final StringBuilder sb = new StringBuilder(sum.toString());
        sb.reverse();
        final char digits[] = sb.toString().toCharArray();
        if (digits.length > 0) {
            final ListNode node = new ListNode(Character.getNumericValue(digits[0]));
            ListNode prevNode = node;
            for (int i = 1; i < digits.length; i++) {
                final ListNode newNode = new ListNode(Character.getNumericValue(digits[i]));
                prevNode.next = newNode;                
                prevNode = newNode;
            }   
            return node;
        }        
        return null;
    }
    
    private static BigInteger toInt(final ListNode node) {
        final StringBuilder sb = new StringBuilder();
        ListNode currentNode = node;
        while (currentNode != null) {
            sb.insert(0, currentNode.val);
            currentNode = currentNode.next;
        }
        return new BigInteger(sb.toString());
    }
}
