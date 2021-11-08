package main.java.medium;

/*
    Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target
    You may return the answer in any order.

    Example 1:
    Input: nums = [1,0,-1,0,-2,2], target = 0
    Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    Example 2:
    Input: nums = [2,2,2,2,2], target = 8
    Output: [[2,2,2,2]]

    Constraints:

    1 <= nums.length <= 200
    -109 <= nums[i] <= 109
    -109 <= target <= 109
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(isNotDublicates(i, 0, nums)) {
                for(int j = i + 1; j < nums.length - 2; j++) {
                    if(isNotDublicates(j, i + 1, nums)) {
                        for(int k = j + 1; k < nums.length - 1; k++) {
                            if(isNotDublicates(k, j + 1, nums)) {
                                for(int n = k + 1; n < nums.length; n++) {
                                    if(isNotDublicates(n, k + 1, nums)) {
                                        int resSum = nums[i] + nums[j] + nums[k] + nums[n];
                                        if(resSum == target) {
                                            result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[n]));
                                        } else if(resSum > target) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isNotDublicates(int target, int min, int[] nums) {
        return target == min || (target > min && nums[target] != nums[target - 1]);
    }
}

/*
    Runtime: 180 ms, faster than 13.22% of Java online submissions for 4Sum.
    Memory Usage: 39.6 MB, less than 68.00% of Java online submissions for 4Sum.
*/
