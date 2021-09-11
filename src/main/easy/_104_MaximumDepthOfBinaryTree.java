package main.easy;

/*
    Given the root of a binary tree, return its maximum depth.

    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: 3
    Example 2:

    Input: root = [1,null,2]
    Output: 2
    Example 3:

    Input: root = []
    Output: 0
    Example 4:

    Input: root = [0]
    Output: 1

    Constraints:

    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
*/

public class _104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    public int getDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return left > right ? ++left : ++right;
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
    Memory Usage: 40.5 MB, less than 9.50% of Java online submissions for Maximum Depth of Binary Tree.
*/


