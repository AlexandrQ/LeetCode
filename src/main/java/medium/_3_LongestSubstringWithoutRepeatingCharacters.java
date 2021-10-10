package main.java.medium;

/*
    Given a string s, find the length of the longest substring without repeating characters.

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Example 4:
    Input: s = ""
    Output: 0

    Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
*/

public class _3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int charIndex = sb.indexOf((ch + ""));
            if (charIndex > -1) {
                sb.delete(0, charIndex + 1);
                sb.append(ch);
                continue;
            }
            sb.append(ch);
            if (sb.length() > max) {
                max = sb.length();
            }
        }
        return max;
    }
}

/*
    Runtime: 22 ms, faster than 22.45% of Java online submissions for Longest Substring Without Repeating Characters.
    Memory Usage: 44 MB, less than 9.01% of Java online submissions for Longest Substring Without Repeating Characters.
*/
