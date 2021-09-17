package main.easy;

/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:

    MinStack() initializes the stack object.
    void push(val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.

    Example 1:

    Input
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    Output
    [null,null,null,null,-3,null,0,-2]

    Explanation
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2

    Constraints:

    -231 <= val <= 231 - 1
    Methods pop, top and getMin operations will always be called on non-empty stacks.
    At most 3 * 104 calls will be made to push, pop, top, and getMin.
*/

public class _155_MinStack {
    class MinStack {
        private StackNode head;


        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int val) {
            Integer.MAX_VALUE;
            if(this.head == null) {
                head = new StackNode(val);
            } else {
                head = new StackNode(val, head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return getRecursiveMin(head);
        }

        private int getRecursiveMin(StackNode node) {
            if(node.next != null) {
                return Math.min(node.val, getRecursiveMin(node.next));
            }
            return node.val;
        }

        class StackNode {
            int val;
            StackNode next;
            StackNode(int intValue) {
                this.val = intValue;
            }
            StackNode(int intValue, StackNode node) {
                this.val = intValue;
                this.next = node;
            }
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}

/*
    Runtime: 190 ms, faster than 5.62% of Java online submissions for Min Stack.
    Memory Usage: 45.9 MB, less than 6.09% of Java online submissions for Min Stack.
*/
