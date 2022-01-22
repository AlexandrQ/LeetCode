package main.java.medium;

import java.util.HashMap;
import java.util.Map;

/*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

    In other words, return true if one of s1's permutations is the substring of s2.

    Example 1:
    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").

    Example 2:
    Input: s1 = "ab", s2 = "eidboaoo"
    Output: false

    Constraints:
    1 <= s1.length, s2.length <= 104
    s1 and s2 consist of lowercase English letters.
*/

public class _567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> charsCountMap = new HashMap<>();
        char[] s1chars = s1.toCharArray();
        for(int i = 0; i < s1chars.length; i++) {
            Character ch = s1chars[i];
            Integer count = charsCountMap.get(ch);
            charsCountMap.put(ch, count == null ? 1 : ++count);
        }

        char[] s2chars = s2.toCharArray();
        Map<Character, Integer> charsCountMapCopy = null;
        for(int i = 0; i < s2chars.length; i++) {
            charsCountMapCopy = new HashMap<>(charsCountMap);
            for(int j = i; j < s2chars.length; j++) {
                Character ch = s2chars[j];
                Integer count = charsCountMapCopy.get(ch);
                if(count != null) {
                    count = --count;
                    if(count == 0) {
                        charsCountMapCopy.remove(ch);
                        if(charsCountMapCopy.isEmpty()) {
                            return true;
                        }
                    } else {
                        charsCountMapCopy.put(ch, count);
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}

/*
    Runtime: 2302 ms, faster than 5.01% of Java online submissions for Permutation in String.
    Memory Usage: 141.5 MB, less than 5.03% of Java online submissions for Permutation in String.
*/
