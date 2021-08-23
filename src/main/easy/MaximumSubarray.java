package main.easy;

public class MaximumSubarray {
    /*public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }*/

    /*public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int sumLessThanZero = 0;
        int sumGreaterThanZero = 0;
        boolean subsequenceLessThanZero = false;
        boolean subsequenceGreaterThanZero = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                if(subsequenceLessThanZero && sumGreaterThanZero + sumLessThanZero < 0) {
                    subsequenceLessThanZero = false;
                    sumLessThanZero = 0;
                    sumGreaterThanZero = 0;
                    sum = 0;
                }
                sumGreaterThanZero += nums[i];
                subsequenceGreaterThanZero = true;
                subsequenceLessThanZero = false;
            } else if(nums[i] < 0) {
                if(subsequenceGreaterThanZero && sumGreaterThanZero + sumLessThanZero < 0) {
                    subsequenceGreaterThanZero = false;
                    sum = 0;
                    sumLessThanZero = 0;
                    sumGreaterThanZero = 0;
                }
                sumLessThanZero += nums[i];
                subsequenceLessThanZero = true;
                subsequenceGreaterThanZero = false;
            }
            sum += nums[i];
            if(max < sum) {
                max = sum;
            } else if(max < nums[i]) {
                max = nums[i];
                sum = nums[i];
                if(nums[i] > 0) {
                    sumGreaterThanZero = nums[i];
                    sumLessThanZero = 0;
                } else {
                    sumGreaterThanZero = 0;
                    sumLessThanZero = nums[i];
                }
            }
        }
        return max;
    }*/

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int sumLessThanZero = 0;
        int sumGreaterThanZero = 0;
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > 0) {
                sumGreaterThanZero += nums[i];
            } else if(nums[i] < 0) {
                sumLessThanZero += nums[i];
            }

            sum += nums[i];
            if(max < sum) {
                max = sum;
            } else if(max < nums[i]) {
                max = nums[i];
                sum = nums[i];
            }

            if(sumGreaterThanZero + sumLessThanZero < 0) {
                sum = 0;
                sumLessThanZero = 0;
                sumGreaterThanZero = 0;
            }
        }
        return max;
    }
}
