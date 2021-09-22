package main.easy;

/*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= first < second <= numbers.length.

    Return the indices of the two numbers, index1 and index2, as an integer array [index1, index2] of length 2.

    The tests are generated such that there is exactly one solution. You may not use the same element twice.

    Example 1:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
    Example 2:

    Input: numbers = [2,3,4], target = 6
    Output: [1,3]
    Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3.

    Example 3:

    Input: numbers = [-1,0], target = -1
    Output: [1,2]
    Explanation: The sum of 1 and 0 is -1. Therefore index1 = 1, index2 = 2.

    Constraints:

    2 <= numbers.length <= 3 * 104
    -1000 <= numbers[i] <= 1000
    numbers is sorted in non-decreasing order.
    -1000 <= target <= 1000
    The tests are generated such that there is exactly one solution.
*/

public class _167_TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        final int limit = target/2;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] <= limit) {
                final int searchNum = target - numbers[i];
                int searchIndex = findNumberIndex(searchNum, numbers, i + 1, numbers.length - 1);
                if(searchIndex > -1) {
                    res[0] = ++i;
                    res[1] = ++searchIndex;
                    break;
                }
            } else {
                break;
            }
        }
        return res;
    }

    private int findNumberIndex(int searchNum, int[] arr, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == searchNum) {
                return mid;
            } else if(arr[mid] < searchNum) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

/*
    Runtime: 2 ms, faster than 27.90% of Java online submissions for Two Sum II - Input array is sorted.
    Memory Usage: 39.3 MB, less than 59.96% of Java online submissions for Two Sum II - Input array is sorted.
*/
