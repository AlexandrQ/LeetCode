package main.easy;

/*
    Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

    You may assume the integer does not contain any leading zero, except the number 0 itself.

    Example 1:

    Input: digits = [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Example 2:

    Input: digits = [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
    Example 3:

    Input: digits = [0]
    Output: [1]

    Constraints:

    1 <= digits.length <= 100
    0 <= digits[i] <= 9
*/

public class _066_PlusOne {
    public int[] plusOne(int[] digits) {
        int count = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
                count++;
            }
        }

        if(count == digits.length) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            return newArr;
        }
        return digits;
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
    Memory Usage: 37.2 MB, less than 90.01% of Java online submissions for Plus One.
*/
