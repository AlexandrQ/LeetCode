package main.java.medium;

/*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

    The replacement must be in place and use only constant extra memory.

    Example 1:
    Input: nums = [1,2,3]
    Output: [1,3,2]

    Example 2:
    Input: nums = [3,2,1]
    Output: [1,2,3]

    Example 3:
    Input: nums = [1,1,5]
    Output: [1,5,1]

    Example 4:
    Input: nums = [1]
    Output: [1]

    Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 100
*/

public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--) {
            sortInRange(i + 1, nums);
            int index = findIndex(i, nums);
            if(index != -1) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                sortInRange(i + 1, nums);
                return;
            }
        }
        sortInRange(0, nums);
    }

    private int findIndex(int indexForSearch, int[] nums) {
        if(indexForSearch + 1 <= nums.length) {
            for(int searchNum = nums[indexForSearch] + 1; searchNum <= 100; searchNum++) {
                int start = indexForSearch + 1;
                int end = nums.length - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if(nums[mid] == searchNum) {
                        return mid;
                    } else if(searchNum < nums[mid]) {
                        end = mid - 1;
                    } else if(searchNum > nums[mid]) {
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }




    private void sortInRange(int from, int[] nums) {
        if(from == nums.length - 1) {
            return;
        }
        boolean needIteration = true;
        while(needIteration) {
            needIteration = false;
            for(int i = from + 1; i < nums.length; i++) {
                if(nums[i] < nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                    needIteration = true;
                }
            }
        }
    }
}

/*
    Runtime: 2 ms
    Memory Usage: 39.2 MB
    Your runtime beats 12.59% of java submissions.
*/
