package main.java.easy;

/*
    Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

    A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

    Constraints:
    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in a strictly increasing order.
*/

import main.java.TreeNode;

public class _108_ConvertSortedArrayToBinarySearchTree {

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return createBalancedTree(nums, 0, nums.length - 1);
        }

        private TreeNode createBalancedTree(int[] arr, int start, int end) {
            if(start == end) {
                return new TreeNode(arr[start]);
            } else if(end - start == 1) {
                return new TreeNode(arr[end], new TreeNode(arr[start]), null);
            }
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(arr[mid]);
            node.left = createBalancedTree(arr, start, mid - 1);
            node.right = createBalancedTree(arr, mid + 1, end);
            return node;
        }
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
    Memory Usage: 38.6 MB, less than 68.52% of Java online submissions for Convert Sorted Array to Binary Search Tree.
*/
