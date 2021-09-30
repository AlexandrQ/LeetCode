package main.java.easy;

/*
    Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.
    Example 2:

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.


    Constraints:

    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.
*/

public class _125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            String startStr = s.substring(start, start + 1);
            if(!isAlphanumeric(startStr)) {
                start++;
                continue;
            }
            String endStr = s.substring(end, end + 1);
            if(!isAlphanumeric(endStr)) {
                end++;
                continue;
            }
            if(!startStr.toLowerCase().equals(endStr.toLowerCase())) {
                return false;
            }
            start++;
            end++;
        }
        return true;
    }

    private boolean isAlphanumeric(String ch) {
        return ch.matches("^[a-zA-Z0-9]*$");
    }

/*
    Runtime: 155 ms, faster than 11.65% of Java online submissions for Valid Palindrome.
    Memory Usage: 115.3 MB, less than 5.12% of Java online submissions for Valid Palindrome.
*/
}
