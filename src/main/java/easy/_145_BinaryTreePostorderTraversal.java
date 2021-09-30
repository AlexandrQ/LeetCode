package main.java.easy;

/*
    Given the root of a binary tree, return the postorder traversal of its nodes' values.

    Example 1:
    Input: root = [1,null,2,3]
    Output: [3,2,1]

    Example 2:
    Input: root = []
    Output: []

    Example 3:
    Input: root = [1]
    Output: [1]

    Constraints:

    The number of the nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

    Follow up: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayList;
import java.util.List;

public class _145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fillTheList(root, list);
        return list;
    }

    private void fillTheList(TreeNode node, List<Integer> list) {
        if(node != null) {
            fillTheList(node.left, list);
            fillTheList(node.right, list);
            list.add(node.val);
        }
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
    Memory Usage: 38.9 MB, less than 12.14% of Java online submissions for Binary Tree Postorder Traversal.
.*/


