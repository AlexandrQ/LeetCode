package main.java.easy;

/*
    Given a binary tree, determine if it is height-balanced.

    For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

    Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -104 <= Node.val <= 104
*/

import main.java.TreeNode;

public class _110_BalancedBinaryTree {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root != null) {
            testMethod(root);
        }
        return isBalanced;
    }

    private int testMethod(TreeNode node) {
        if(isBalanced && node!=null) {
            int left = testMethod(node.left);
            int right = testMethod(node.right);
            if(left - right > 1 || right - left > 1) {
                isBalanced = false;
            }
            return (Math.max(left, right)) + 1;
        }
        return 0;
    }
}

/*
    Runtime: 1 ms, faster than 52.16% of Java online submissions for Balanced Binary Tree.
    Memory Usage: 41.9 MB, less than 7.55% of Java online submissions for Balanced Binary Tree.
*/
