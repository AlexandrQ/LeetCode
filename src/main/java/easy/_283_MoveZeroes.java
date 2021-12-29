package main.java.easy;

/*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.

    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:
    Input: nums = [0]
    Output: [0]

    Constraints:
    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1

    Follow up: Could you minimize the total number of operations done?
*/

public class _283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int startZerosTailIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0 && startZerosTailIndex != -1) {
                nums[startZerosTailIndex] = nums[i];
                nums[i] = 0;
                startZerosTailIndex++;
            } else if(nums[i] == 0 && startZerosTailIndex == -1) {
                startZerosTailIndex = i;
            }
        }
    }
}

/*
    Runtime: 2 ms, faster than 40.09% of Java online submissions for Move Zeroes.
    Memory Usage: 40.5 MB, less than 24.08% of Java online submissions for Move Zeroes.
*/
