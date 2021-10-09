package main.java.medium;

import main.java.ListNode;

/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example 1:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Example 2:
    Input: l1 = [0], l2 = [0]
    Output: [0]

    Example 3:
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

    Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.
*/

public class _2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1current = l1;
        ListNode l2current = l2;
        ListNode prevNode = null;
        ListNode head = null;
        int savedNum = 0;
        while(l1current != null ||  l2current != null) {
            int num;
            if(l1current != null &&  l2current != null) {
                num = l1current.val + l2current.val + savedNum;
                l1current = l1current.next;
                l2current = l2current.next;
            } else if(l1current != null) {
                num = l1current.val + savedNum;
                l1current = l1current.next;
            } else {
                num = l2current.val + savedNum;
                l2current = l2current.next;
            }
            if(num > 9) {
                savedNum = 1;
                num = num%10;
            } else {
                savedNum = 0;
            }
            ListNode node = new ListNode(num);
            if(prevNode == null) {
                head = node;
            } else {
                prevNode.next = node;
            }
            prevNode = node;
            if(savedNum > 0) {
                prevNode.next = new ListNode(savedNum);
            }
        }
        return head;
    }
}

/*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
    Memory Usage: 39.3 MB, less than 62.20% of Java online submissions for Add Two Numbers.
*/
