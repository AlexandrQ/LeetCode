package main.java.medium;

import main.java.ListNode;

/*
    Given a linked list, swap every two adjacent nodes and return its head.
    You must solve the problem without modifying the values in the list's nodes
    (i.e., only nodes themselves may be changed.)

    Example 1:
    Input: head = [1,2,3,4]
    Output: [2,1,4,3]

    Example 2:
    Input: head = []
    Output: []

    Example 3:
    Input: head = [1]
    Output: [1]

    Constraints:
    The number of nodes in the list is in the range [0, 100].
    0 <= Node.val <= 100
*/

public class _24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        } else if(head.next == null) {
            return head;
        } else {
            ListNode result = head.next;
            swap(null, null, head);
            return result;
        }
    }

    private void swap(ListNode prevPrevNode, ListNode prevNode, ListNode node) {
        if(node != null) {
            if(prevNode == null) {
                swap(prevPrevNode, node, node.next);
            } else {
                ListNode temp = node.next;
                node.next = prevNode;
                prevNode.next = temp;
                if(prevPrevNode != null) {
                    prevPrevNode.next = node;
                }
                swap(prevNode, null, temp);
            }
        }
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
    Memory Usage: 36.6 MB, less than 63.68% of Java online submissions for Swap Nodes in Pairs.
*/
