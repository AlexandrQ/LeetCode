package main.easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given the root of a binary tree, return the inorder traversal of its nodes' values.

    Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

    Follow up: Recursive solution is trivial, could you do it iteratively?
*/

public class _094_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        stepInNode(root, result);
        return result;
    }

    private void stepInNode(TreeNode root, List<Integer> result) {
        if(root.left != null) {
            stepInNode(root.left, result);
        }
        result.add(root.val);
        if(root.right != null) {
            stepInNode(root.right, result);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
    Memory Usage: 37.2 MB, less than 67.14% of Java online submissions for Binary Tree Inorder Traversal.
*/


