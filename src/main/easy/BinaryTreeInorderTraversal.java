package main.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resilt = new ArrayList<>(0);
        testM(root, resilt);
        return resilt;
    }

    private void testM(TreeNode root, List<Integer> resilt) {
        if(root.left != null) {
            testM(root.left, resilt);
        }
        resilt.add(root.val);
        if(root.right != null) {
            testM(root.right, resilt);
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



