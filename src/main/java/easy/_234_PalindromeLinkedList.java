package main.java.easy;

/*
    Given the head of a singly linked list, return true if it is a palindrome.

    Example 1:
    Input: head = [1,2,2,1]
    Output: true

    Example 2:
    Input: head = [1,2]
    Output: false

    Constraints:
    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9

    Follow up: Could you do it in O(n) time and O(1) space?
*/

import main.java.ListNode;

public class _234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        //ListNode reverted = getRevertedList(new ListNode(head.val), head.next);
        //return isEquals(head, reverted);
        return isPalindrome(head, head) != null;
    }

    private ListNode isPalindrome(ListNode leftToRightNode, ListNode rightToLeftNode) {
        if(leftToRightNode == null) {
            return rightToLeftNode;
        }
        ListNode node = isPalindrome(leftToRightNode.next, rightToLeftNode);
        if(node == null) {
            return null;
        }
        return leftToRightNode.val == node.val ? node.next == null ? node : node.next : null;
    }

    /*private boolean isEquals(ListNode one, ListNode two) {
        if(one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        }
        return one.val == two.val && isEquals(one.next, two.next);
    }

    private ListNode getRevertedList(ListNode newTail, ListNode next) {
        if(next == null) {
            return newTail;
        }
        ListNode node = new ListNode(next.val, newTail);
        return getRevertedList(node, next.next);
    }*/
}

/*
    Runtime: 17 ms, faster than 33.60% of Java online submissions for Palindrome Linked List.
    Memory Usage: 101.4 MB, less than 30.92% of Java online submissions for Palindrome Linked List.
*/
