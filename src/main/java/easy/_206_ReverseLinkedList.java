package main.java.easy;

/*
    Given the head of a singly linked list, reverse the list, and return the reversed list.

    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

    Example 2:
    Input: head = [1,2]
    Output: [2,1]

    Example 3:
    Input: head = []
    Output: []

    Constraints:
    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

    Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

import main.java.ListNode;

public class _206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return setNext(null, head);
    }

    private ListNode setNext(ListNode futureNext, ListNode current) {
        if(current == null) {
            return futureNext;
        }
        ListNode savedOldNext = current.next;
        current.next = futureNext;
        return setNext(current, savedOldNext);
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    Memory Usage: 39 MB, less than 41.89% of Java online submissions for Reverse Linked List.
*/
