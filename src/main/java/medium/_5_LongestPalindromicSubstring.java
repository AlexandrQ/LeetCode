package main.java.medium;

/*
    Given a string s, return the longest palindromic substring in s.

    Example 1:

    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: s = "cbbd"
    Output: "bb"
    Example 3:

    Input: s = "a"
    Output: "a"
    Example 4:

    Input: s = "ac"
    Output: "a"

    Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.
*/

public class _5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        } else if(s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? s : s.charAt(0) + "";
        }
        String maxPalindrome = "";
        for(int i = 0; i < s.length(); i++) {
            String processedOddPalindrome = processOdd(s, i);
            String processedEvenPalindrome = processEven(s, i);
            if(processedOddPalindrome.length() > maxPalindrome.length()) {
                maxPalindrome = processedOddPalindrome;
            }
            if(processedEvenPalindrome.length() > maxPalindrome.length()) {
                maxPalindrome = processedEvenPalindrome;
            }
        }
        return maxPalindrome;
    }

    private String processOdd(String str, int index) {
        int step = 1;
        while(index - step >= 0 && index + step <= str.length() - 1) {
            if(str.charAt(index - step) == str.charAt(index + step)) {
                step++;
            } else {
                break;
            }
        }
        return str.substring(index - step + 1, index + step);
    }

    private String processEven(String str, int index) {
        if(index == str.length() - 1) {
            return str.charAt(index) + "";
        }
        int stepLeft = index;
        int stepRight = index + 1;
        if(str.charAt(stepLeft) == str.charAt(stepRight)) {
            stepLeft--;
            stepRight++;
            while(stepLeft >= 0 && stepRight <= str.length() - 1) {
                if(str.charAt(stepLeft) == str.charAt(stepRight)) {
                    stepLeft--;
                    stepRight++;
                } else {
                    break;
                }
            }
        }
        return str.substring(stepLeft + 1, stepRight);
    }
}

/*
    Runtime: 32 ms, faster than 63.12% of Java online submissions for Longest Palindromic Substring.
    Memory Usage: 39.8 MB, less than 50.64% of Java online submissions for Longest Palindromic Substring.
*/
