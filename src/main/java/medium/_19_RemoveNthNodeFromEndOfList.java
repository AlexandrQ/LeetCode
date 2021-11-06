package main.java.medium;

/*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
    Example 1:
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]

    Example 2:
    Input: head = [1], n = 1
    Output: []

    Example 3:
    Input: head = [1,2], n = 1
    Output: [1]

    Constraints:
    The number of nodes in the list is sz.
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz

    Follow up: Could you do this in one pass?
*/

import main.java.ListNode;

public class _19_RemoveNthNodeFromEndOfList {
    private ListNode resHead;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        resHead = head;
        m(null, head, n);
        return resHead;
    }

    private int m(ListNode prevNode, ListNode node, int n) {
        if(node == null) {
            return 0;
        }
        int count = m(node, node.next, n) + 1;
        if(count == n) {
            if(prevNode != null) {
                prevNode.next = node.next;
            } else {
                resHead = node.next;
            }
        }
        return count;
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
    Memory Usage: 39.3 MB, less than 12.40% of Java online submissions for Remove Nth Node From End of List.
*/
