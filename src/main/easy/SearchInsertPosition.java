package main.easy;

public class SearchInsertPosition {
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
