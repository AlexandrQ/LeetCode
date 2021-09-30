package main.java.easy;

/*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.

    Example 1:

    Input: nums = [2,2,1]
    Output: 1
    Example 2:

    Input: nums = [4,1,2,1,2]
    Output: 4
    Example 3:

    Input: nums = [1]
    Output: 1

    Constraints:

    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.
*/

public class _136_SingleNumber {
    public int singleNumber(int[] nums) {
        int[] arr = new int[nums.length / 2 + 1];
        int count = 0;
        for (int num : nums) {
            if (count > 0) {
                boolean isOnce = true;
                for (int j = 0; j < count; j++) {
                    if (arr[j] == num) {
                        isOnce = false;
                        arr[j] = 0;
                        break;
                    }
                }
                if (isOnce) {
                    arr[count] = num;
                    count++;
                }
            } else {
                arr[count] = num;
                count++;
            }
        }
        for (int j : arr) {
            if (j != 0) {
                return j;
            }
        }
        return 0;
    }

/*
    Runtime: 129 ms, faster than 7.90% of Java online submissions for Single Number.
    Memory Usage: 39.2 MB, less than 68.41% of Java online submissions for Single Number.
*/
}
