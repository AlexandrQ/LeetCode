package main.java.easy;

/*
    Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

    A leaf is a node with no children.
*/

public class _112_PathSum {
    private boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        hasPathSum(root, 0, targetSum);
        return result;
    }

    private void hasPathSum(TreeNode node, int currentSum, int targetSum) {
        if(!result && node != null) {
            if(node.left != null) {
                hasPathSum(node.left, currentSum + node.val, targetSum);
            }
            if(node.right != null) {
                hasPathSum(node.right, currentSum + node.val, targetSum);
            }
            if(node.left == null && node.right == null && currentSum + node.val == targetSum) {
                result = true;
            }
        }
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
    Memory Usage: 41 MB, less than 8.47% of Java online submissions for Path Sum.
*/
