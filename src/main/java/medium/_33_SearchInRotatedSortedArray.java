package main.java.medium;

/*
    There is an integer array nums sorted in ascending order (with distinct values).

    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1

    Example 3:
    Input: nums = [1], target = 0
    Output: -1

    Constraints:

    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -104 <= target <= 104
*/

public class _33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length <= 2) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        if(nums[0] > nums[nums.length - 1]) {
            int border = findBorder(nums, 0, nums.length - 1);
            if(target == nums[nums.length - 1]) {
                return nums.length - 1;
            } else if(target < nums[nums.length - 1]) {
                return binarySearch(nums, border, nums.length - 1, target);
            } else {
                return binarySearch(nums, 0, border - 1, target);
            }
        } else {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
    }

    private int findBorder(int[] nums, int start, int end) {
        int endVal = nums[nums.length - 1];
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid == 0 && nums[0] > endVal && nums[1] <= endVal) {
                return 1;
            }
            if(endVal <= nums[mid - 1] && nums[mid] <= endVal) {
                return mid;
            } else if(nums[mid] < endVal && nums[mid - 1] < endVal) {
                return findBorder(nums, start, mid - 1);
            } else {
                return findBorder(nums, mid + 1, end);
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int start, int end, int find) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == find) {
                return mid;
            } else if(nums[mid] < find) {
                return binarySearch(nums, mid + 1, end, find);
            } else {
                return binarySearch(nums, start, mid - 1, find);
            }
        }
        return -1;
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
    Memory Usage: 38.3 MB, less than 71.40% of Java online submissions for Search in Rotated Sorted Array.
*/
