package main.easy;

/*
    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

    Example 1:
    Input: head = [1,1,2]
    Output: [1,2]

    Example 2:
    Input: head = [1,1,2,3,3]
    Output: [1,2,3]

    Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.
*/

public class _083_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode node = head;
        while(node.next != null) {
            if(node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }

    public static ListNode getListNodes(int[] array) {
        ListNode prev = new ListNode(array[0]);
        ListNode head = prev;
        for(int i = 1; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            prev.setNext(newNode);
            prev = newNode;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

        public ListNode(ListNode node) {
            this.val = node.val;
            this.next = node.next;
        }

        public String printAllValues() {
            String res = "";
            ListNode node = new ListNode(val, next);
            while(node != null) {
                res += node.val + " ";
                if(node.next == null) {
                    node = null;
                } else {
                    node = new ListNode(node.next);
                }
            }
            return res;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
    Memory Usage: 38.6 MB, less than 22.16% of Java online submissions for Remove Duplicates from Sorted List.
*/


