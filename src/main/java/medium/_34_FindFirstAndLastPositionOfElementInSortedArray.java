package main.java.medium;

/*
    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    If target is not found in the array, return [-1, -1].
    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

    Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

    Example 3:
    Input: nums = [], target = 0
    Output: [-1,-1]

    Constraints:
    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
    nums is a non-decreasing array.
    -109 <= target <= 109
*/

public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private int leftBorder = 0;
    private int rightBorder;
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[] {-1, -1};
        } if(nums.length == 1 && nums[0] == target) {
            return new int[] {0, 0};
        }
        rightBorder = nums.length - 1;
        testM(nums, target, leftBorder, rightBorder);
        if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
            return new int[] {-1, -1};
        } else if(min != Integer.MAX_VALUE && max == Integer.MIN_VALUE ) {
            return new int[] {min, min};
        } else if(max != Integer.MIN_VALUE && min == Integer.MAX_VALUE) {
            return new int[] {max, max};
        } else {
            return new int[] {min, max};
        }
    }

    private void testM(int[] nums, int target, int start, int end) {
        int index = binarySearch(nums, target, start ,end);
        if(index != -1) {
            testM(nums, target, rightBorder, index - 1);
            testM(nums, target, index + 1, end);
        }
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if(start <= end && start >= 0 && end < nums.length) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                if(mid < min) {
                    min = mid;
                }
                if(max < mid) {
                    max = mid;
                }
                return mid;
            } else if(nums[mid] < target) {
                return binarySearch(nums, target, mid + 1, end);
            } else {
                return binarySearch(nums, target, start, mid - 1);
            }
        }
        return -1;
    }

/*
    Runtime: 1 ms, faster than 16.86% of Java online submissions for Find First and Last Position of Element in Sorted Array.
    Memory Usage: 44.2 MB, less than 14.57% of Java online submissions for Find First and Last Position of Element in Sorted Array.
*/
}
