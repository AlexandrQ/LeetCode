package main.java.medium;

/*
    Given a binary array nums, you should delete one element from it.
    Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

    Example 1:
    Input: nums = [1,1,0,1]
    Output: 3
    Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

    Example 2:
    Input: nums = [0,1,1,1,0,1,1,0,1]
    Output: 5
    Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

    Example 3:
    Input: nums = [1,1,1]
    Output: 2
    Explanation: You must delete one element.

    Constraints:
    1 <= nums.length <= 105
    nums[i] is either 0 or 1.
*/

public class _1493_LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int maxCount = 0;
        int tempMaxCount = 0;
        int currentCount = 0;
        int prevCount = 0;
        int countZerros = 0;
        boolean hasZerro = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                currentCount++;
                if(countZerros > 1) {
                    countZerros = 0;
                }
                if(i == nums.length - 1 && maxCount < prevCount + currentCount) {
                    maxCount = prevCount + currentCount;
                }
            } else {
                hasZerro = true;
                if(currentCount > 0 || prevCount > 0) {
                    countZerros++;
                    if(maxCount < prevCount + currentCount) {
                        maxCount =  prevCount + currentCount;
                    }
                    if(countZerros == 1) {
                        prevCount = currentCount;
                    } else if(countZerros > 1 && currentCount == 0) {
                        prevCount = 0;
                    } else if(countZerros > 1 && currentCount > 0) {
                        prevCount = currentCount;
                        countZerros = 1;
                    }
                    currentCount = 0;
                }

            }
        }
        return hasZerro ? maxCount : --maxCount;
    }
}

/*
    Runtime: 2 ms, faster than 58.02% of Java online submissions for Longest Subarray of 1's After Deleting One Element.
    Memory Usage: 47.7 MB, less than 83.02% of Java online submissions for Longest Subarray of 1's After Deleting One Element.
*/
