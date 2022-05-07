package main.java.medium;

/*
    Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

    Example 1:
    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
    Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

    Example 2:
    Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
    Output: 10
    Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

    Constraints:
    1 <= nums.length <= 105
    nums[i] is either 0 or 1.
    0 <= k <= nums.length
*/

import java.util.LinkedList;
import java.util.Queue;

public class _1004_MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        Queue<Integer> invertedZerrosIndexes = new LinkedList<>();
        int maxLength = 0;
        int firstIndex = k > 0 ? 0 : -1;
        int lastIndex = firstIndex;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(firstIndex == -1) {
                    firstIndex = i;
                }
                lastIndex = i;
            } else {
                if(k > 0) {
                    if(invertedZerrosIndexes.size() == k) {
                        firstIndex = invertedZerrosIndexes.poll() + 1;
                    }
                    invertedZerrosIndexes.add(i);
                    lastIndex = i;
                } else {
                    firstIndex = -1;
                    lastIndex = -1;
                }
            }
            int currentLength = countLength(firstIndex, lastIndex);
            if(currentLength > maxLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }

    private int countLength(int firstIndex, int lastIndex) {
        return firstIndex == -1 || lastIndex == -1 ? 0 : lastIndex - firstIndex + 1;
    }
}

/*
    Runtime: 13 ms, faster than 6.60% of Java online submissions for Max Consecutive Ones III.
    Memory Usage: 68.2 MB, less than 62.52% of Java online submissions for Max Consecutive Ones III.
*/
