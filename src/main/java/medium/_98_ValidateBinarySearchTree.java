package main.java.medium;

/*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:
    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    Example 1:
    Input: root = [2,1,3]
    Output: true

    Example 2:
    Input: root = [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.

    Constraints:
    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1
*/

import main.java.TreeNode;

public class _98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidLeft(null, root.val, root.left) && isValidRight(root.val, null, root.right);
    }

    private boolean isValidLeft(Integer leftBorder, Integer rightBorder, TreeNode node) {
        if(node == null) {
            return true;
        }
        boolean leftIsOk = leftBorder == null || leftBorder < node.val;
        boolean rightIsOk = rightBorder == null || node.val < rightBorder;

        return leftIsOk && rightIsOk &&
                isValidLeft(leftBorder, node.val, node.left) &&
                isValidRight(node.val, rightBorder, node.right);
    }

    private boolean isValidRight(Integer leftBorder, Integer rightBorder, TreeNode node) {
        if(node == null) {
            return true;
        }
        boolean leftIsOk = leftBorder == null || leftBorder < node.val;
        boolean rightIsOk = rightBorder == null || node.val < rightBorder;

        return leftIsOk && rightIsOk &&
                isValidLeft(leftBorder, node.val, node.left) &&
                isValidRight(node.val, rightBorder, node.right);
    }
}

/*
    Runtime: 1 ms, faster than 59.57% of Java online submissions for Validate Binary Search Tree.
    Memory Usage: 44.7 MB, less than 6.51% of Java online submissions for Validate Binary Search Tree.
*/
