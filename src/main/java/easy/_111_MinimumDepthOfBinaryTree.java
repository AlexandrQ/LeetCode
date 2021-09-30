package main.java.easy;

/*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    Note: A leaf is a node with no children.
*/

public class _111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return ++right;
        } else if(right == 0) {
            return ++left;
        }
        return left < right ? ++left : ++right;
    }
}

/*
    Runtime: 6 ms, faster than 29.29% of Java online submissions for Minimum Depth of Binary Tree.
    Memory Usage: 59.8 MB, less than 57.83% of Java online submissions for Minimum Depth of Binary Tree.
*/


