package main.easy;

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

/*
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    Example 1:
    Input: nums = [3,2,3]
    Output: 3

    Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

    Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -231 <= nums[i] <= 231 - 1

    Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if(count == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], ++count);
            }
        }

        int maxCount = map.get(nums[0]);
        int maxNum = nums[0];
        for(Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxNum = entry.getKey();
            }
        }
        return maxNum;
    }
}

/*
    Runtime: 8 ms, faster than 35.35% of Java online submissions for Majority Element.
    Memory Usage: 44.5 MB, less than 63.40% of Java online submissions for Majority Element.
*/


