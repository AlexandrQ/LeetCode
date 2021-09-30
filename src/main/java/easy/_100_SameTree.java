package main.java.easy;

/*
    Given the roots of two binary trees p and q, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

    Constraints:

    The number of nodes in both trees is in the range [0, 100].
    -104 <= Node.val <= 104
*/

public class _100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if(p == null || q == null) {
            return false;
        }
        return compareNodes(p, q);
    }

    private boolean compareNodes(TreeNode rootOne, TreeNode rootTwo) {
        if((rootOne.left != null && rootTwo.left == null) ||
                (rootOne.left == null && rootTwo.left != null) ||
                (rootOne.right != null && rootTwo.right == null) ||
                (rootOne.right == null && rootTwo.right != null)) {
            return false;
        }
        if(rootOne.left != null && rootTwo.left != null) {
            boolean rez = compareNodes(rootOne.left, rootTwo.left);
            if(!rez) {
                return false;
            }
        }
        if(rootOne.right != null && rootTwo.right != null) {
            boolean rez =  compareNodes(rootOne.right, rootTwo.right);
            if(!rez) {
                return false;
            }
        }
        return rootOne.val == rootTwo.val;
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
    Memory Usage: 36.5 MB, less than 42.73% of Java online submissions for Same Tree.
*/



