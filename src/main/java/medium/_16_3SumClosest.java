package main.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

    Return the sum of the three integers.

    You may assume that each input would have exactly one solution.

    Example 1:
    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    Example 2:
    Input: nums = [0,0,0], target = 1
    Output: 0

    Constraints:
    3 <= nums.length <= 1000
    -1000 <= nums[i] <= 1000
    -104 <= target <= 104
*/

public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 200000;
        for(int i = 0; i <= nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j <= nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int thirdNumber = findThirdNumber(target - (nums[i] + nums[j]), j + 1, nums.length - 1, nums);
                int sum =  nums[i] + nums[j] + thirdNumber;
                if(Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
            }
        }
        return closest;
    }

    private int findThirdNumber(int target, int start, int end, int[] arr) {
        int mid = (start + end) / 2;
        int closest = arr[mid];
        while(start <= end) {
            mid = (start + end) / 2;
            if(Math.abs(arr[mid] - target) < Math.abs(closest - target)) {
                closest = arr[mid];
            }
            if(arr[mid] == target) {
                return target;
            } else if(arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return closest;
    }
}

/*
    Runtime: 36 ms, faster than 10.58% of Java online submissions for 3Sum Closest.
    Memory Usage: 39.8 MB, less than 27.98% of Java online submissions for 3Sum Closest.
*/
