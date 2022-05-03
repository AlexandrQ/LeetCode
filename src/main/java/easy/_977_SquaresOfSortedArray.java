package main.java.easy;

/*
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

    Example 1:
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

    Example 2:
    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]

    Constraints:
    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.

    Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
*/

public class _977_SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        for(int k = nums.length - 1; k >= 0; k--) {
            if(Math.abs(nums[leftPointer]) < Math.abs(nums[rightPointer])) {
                result[k] = nums[rightPointer] * nums[rightPointer];
                rightPointer--;
            } else {
                result[k] = nums[leftPointer] * nums[leftPointer];
                leftPointer++;
            }
        }
        return result;
    }
}

/*
    Runtime: 2 ms, faster than 76.32% of Java online submissions for Squares of a Sorted Array.
    Memory Usage: 55.7 MB, less than 46.41% of Java online submissions for Squares of a Sorted Array.
*/
