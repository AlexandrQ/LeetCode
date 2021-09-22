package main.easy;

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
