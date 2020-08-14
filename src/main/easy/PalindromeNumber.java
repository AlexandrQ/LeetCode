package main.easy;

public class PalindromeNumber {
    /*
        Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

        Example 1:
            Input: 121
            Output: true
        Example 2:
            Input: -121
            Output: false
            Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
        Example 3:
            Input: 10
            Output: false
            Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

        Follow up: Could you solve it without converting the integer to a string?
    */

    private final int INT_SIZE_LIMIT = 10;

    public boolean isPalindrome(int x) {
        if(x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int[] array = new int[INT_SIZE_LIMIT];
        int count = 0;
        while(x != 0) {
            array[count] = x%10;
            x = x / 10;
            count++;
        }

        for(int i = 0; i < count; i++) {
            if(array[i] != array[count - 1 - i]){
                return false;
            }
        }
        return true;
    }

    /*
        Runtime: 7 ms, faster than 84.73% of Java online submissions for Palindrome Number.
        Memory Usage: 39.4 MB, less than 43.56% of Java online submissions for Palindrome Number.
    */
}
