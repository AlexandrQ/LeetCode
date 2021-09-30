package main.java.easy;

/*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    A subarray is a contiguous part of an array.

    Example 1:

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Example 2:

    Input: nums = [1]
    Output: 1
    Example 3:

    Input: nums = [5,4,-1,7,8]
    Output: 23

    Constraints:

    1 <= nums.length <= 3 * 104
    -105 <= nums[i] <= 105

    Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class _053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int sumLessThanZero = 0;
        int sumGreaterThanZero = 0;
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > 0) {
                sumGreaterThanZero += nums[i];
            } else if(nums[i] < 0) {
                sumLessThanZero += nums[i];
            }

            sum += nums[i];
            if(max < sum) {
                max = sum;
            } else if(max < nums[i]) {
                max = nums[i];
                sum = nums[i];
            }

            if(sumGreaterThanZero + sumLessThanZero < 0) {
                sum = 0;
                sumLessThanZero = 0;
                sumGreaterThanZero = 0;
            }
        }
        return max;
    }
}

/*
    Runtime: 1 ms
    Memory Usage: 38.8 MB
*/
