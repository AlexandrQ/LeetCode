package main.java.easy;

public class _035_SearchInsertPosition2 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length-1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid]==target){
                return mid;
            }
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid -1;
        }


        return left;
    }
}
