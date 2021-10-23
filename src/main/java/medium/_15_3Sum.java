package main.java.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.

    Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]

    Example 2:
    Input: nums = []
    Output: []

    Example 3:
    Input: nums = [0]
    Output: []

    Constraints:
    0 <= nums.length <= 3000
    -105 <= nums[i] <= 105
*/

public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i <= nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j <= nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                Integer thirdNumber = findThirdNumber(-(nums[i] + nums[j]), j + 1, nums.length - 1, nums);
                if(thirdNumber != null) {
                    result.add(Arrays.asList(nums[i], nums[j], thirdNumber));
                }
            }
        }
        return result;
    }

    private Integer findThirdNumber(int target, int start, int end, int[] arr) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target) {
                return target;
            } else if(arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return null;
    }
}

/*
    Runtime: 290 ms, faster than 25.81% of Java online submissions for 3Sum.
    Memory Usage: 42.7 MB, less than 91.36% of Java online submissions for 3Sum.
*/
