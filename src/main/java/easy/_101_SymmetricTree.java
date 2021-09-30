package main.java.easy;

/*
    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

    Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    -100 <= Node.val <= 100

    Follow up: Could you solve it both recursively and iteratively?
*/

public class _101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return compareNodes(root.left, root.right);
    }

    private boolean compareNodes(TreeNode rootOne, TreeNode rootTwo) {

        if(rootOne == null && rootTwo == null) {
            return true;
        } else if((rootOne != null && rootTwo == null) ||
                (rootOne == null && rootTwo != null)) {
            return false;
        }

        boolean boolRes = compareNodes(rootOne.left, rootTwo.right);
        if(!boolRes) {
            return false;
        }

        boolRes = compareNodes(rootOne.right, rootTwo.left);
        if(!boolRes) {
            return false;
        }

        return rootOne.val == rootTwo.val;
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
    Memory Usage: 36.8 MB, less than 93.40% of Java online submissions for Symmetric Tree.
*/



