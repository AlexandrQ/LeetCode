package main.java.easy;

/*
    Given the root of a binary tree, return the preorder traversal of its nodes' values.

    Example 1:
    Input: root = [1,null,2,3]
    Output: [1,2,3]

    Example 2:
    Input: root = []
    Output: []

    Example 3:
    Input: root = [1]
    Output: [1]

    Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100


    Follow up: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayList;
import java.util.List;

public class _144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fillTheList(root, list);
        return list;
    }

    private void fillTheList(TreeNode node, List<Integer> list) {
        if(node != null) {
            list.add(node.val);
            fillTheList(node.left, list);
            fillTheList(node.right, list);
        }
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
    Memory Usage: 37.4 MB, less than 46.01% of Java online submissions for Binary Tree Preorder Traversal.
.*/


