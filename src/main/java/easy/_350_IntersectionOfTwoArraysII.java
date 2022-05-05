package main.java.easy;

/*
    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]

    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.

    Constraints:
    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000

    Follow up:
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _350_IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countNums = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            if(countNums.containsKey(nums1[i])) {
                Integer count = countNums.get(nums1[i]);
                countNums.put(nums1[i], ++count);
            } else {
                countNums.put(nums1[i], 1);
            }
        }
        for(int i = 0; i < nums2.length; i++) {
            if(countNums.containsKey(nums2[i])) {
                resultList.add(nums2[i]);
                Integer count = countNums.get(nums2[i]);
                if(count == 1) {
                    countNums.remove(nums2[i]);
                } else {
                    countNums.put(nums2[i], --count);
                }
            }
        }
        int[] resultArr = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }
}

/*
    Runtime: 6 ms, faster than 28.08% of Java online submissions for Intersection of Two Arrays II.
    Memory Usage: 44.4 MB, less than 17.90% of Java online submissions for Intersection of Two Arrays II.
*/
