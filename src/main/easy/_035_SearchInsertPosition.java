package main.easy;

/*
    Given a sorted array of distinct integers and a target value, return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Example 2:

    Input: nums = [1,3,5,6], target = 2
    Output: 1
    Example 3:

    Input: nums = [1,3,5,6], target = 7
    Output: 4
    Example 4:

    Input: nums = [1,3,5,6], target = 0
    Output: 0
    Example 5:

    Input: nums = [1], target = 0
    Output: 0

    Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums contains distinct values sorted in ascending order.
    -104 <= target <= 104
*/

public class _035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 1) {
            return nums[0] == target ? 0 : target < nums[0] ? 0 : 1;
        }
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int start, int end) {
        if(start == end) {
            if(nums[start] == target || target < nums[start]) {
                return start;
            } else {
                return start + 1;
            }
        }

        int mid;
        if(isOdd(end - start)) {
            mid = start + (end - start - 1) / 2;
        } else {
            mid = start + (end - start) / 2;
        }

        if(nums[mid] == target) {
            return mid;
        } else if(target < nums[mid]) {
            if(start == mid && start == 0) {
                return nums[0] == target ? 0 : target < nums[0] ? 0 : 1;
            } else if(start == mid) {
                return searchInsert(nums, target, start, mid);
            }
            return searchInsert(nums, target, start, mid - 1);
        } else {
            if(mid == end && end == nums.length - 1) {
                return nums[end] == target ? end : nums[end] < target  ? end + 1 : end;
            } else if(mid == end) {
                return searchInsert(nums, target, mid, end);
            }
            return searchInsert(nums, target, mid + 1, end);
        }

    }

    private boolean isOdd(int mun) {
        return mun % 2 == 1;
    }
}

/*
    Runtime: 0 ms
    Memory Usage: 38.8 MB
*/
