package main.easy;

/*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

    Return true if there is a cycle in the linked list. Otherwise, return false.

    Constraints:
    The number of the nodes in the list is in the range [0, 104].
    -105 <= Node.val <= 105
    pos is -1 or a valid index in the linked-list.

    Follow up: Can you solve it using O(1) (i.e. constant) memory?
*/

public class _141_LinkedListCycle {
    final int stop_num = 10000000;
    public boolean hasCycle(ListNode head) {
        if(head.next == null) {
            return false;
        } else if(head.val == stop_num) {
            return true;
        }
        head.val = stop_num;
        return hasCycle(head.next);
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
    Memory Usage: 40.6 MB, less than 27.25% of Java online submissions for Linked List Cycle
.*/


