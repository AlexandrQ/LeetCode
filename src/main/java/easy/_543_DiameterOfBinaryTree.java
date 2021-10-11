package main.java.easy;

import main.java.TreeNode;

/*
    Given the root of a binary tree, return the length of the diameter of the tree.

    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    The length of a path between two nodes is represented by the number of edges between them.

    Example 1:
    Input: root = [1,2,3,4,5]
    Output: 3
    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
    Example 2:

    Input: root = [1,2]
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -100 <= Node.val <= 100
*/

public class _543_DiameterOfBinaryTree {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        process(root);
        return this.max;
    }

    private int process(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftDepth = process(node.left);
        int rightDepth = process(node.right);
        this.max = Math.max(this.max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
    Memory Usage: 40.5 MB, less than 28.77% of Java online submissions for Diameter of Binary Tree.
*/
