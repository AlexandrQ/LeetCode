package main.java.medium;

/*
    Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

    Example 1:
    Input: nums = [1,1,1], k = 2
    Output: 2

    Example 2:
    Input: nums = [1,2,3], k = 3
    Output: 2

    Constraints:
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107
*/

public class _560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int j = i + 1;
            while(j <= nums.length) {
                if(sum == k) {
                    count++;
                }
                if(j == nums.length) {
                          break;
                }
                sum += nums[j];
                j++;
            }
        }
        return count;
    }
}

/*
    Runtime: 1600 ms, faster than 5.00% of Java online submissions for Subarray Sum Equals K.
    Memory Usage: 41.2 MB, less than 86.55% of Java online submissions for Subarray Sum Equals K.
*/
