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

    public boolean checkInclusion2(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1CharsCountMap = new HashMap<>();
        Map<Character, Integer> s2CharsCountMap = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            Integer countOne = s1CharsCountMap.get(s1.charAt(i));
            Integer countTwo = s2CharsCountMap.get(s2.charAt(i));
            if(countOne == null) {
                s1CharsCountMap.put(s1.charAt(i), 1);
            } else {
                s1CharsCountMap.put(s1.charAt(i), countOne + 1);
            }

            if(countTwo == null) {
                s2CharsCountMap.put(s2.charAt(i), 1);
            } else {
                s2CharsCountMap.put(s2.charAt(i), countTwo + 1);
            }
        }

        if(isEqMaps(s1CharsCountMap, s2CharsCountMap)) {
            return true;
        }

        for(int i = s1.length(); i < s2.length(); i++) {
            Character leftBorder = s2.charAt(i - s1.length());
            Integer borderCount = s2CharsCountMap.get(leftBorder);
            if(borderCount != null) {
                if(borderCount == 1) {
                    s2CharsCountMap.remove(leftBorder);
                } else {
                    s2CharsCountMap.put(leftBorder, borderCount - 1);
                }
            }

            Character rightBorder = s2.charAt(i);
            Integer borderCountRight = s2CharsCountMap.get(rightBorder);
            if(borderCountRight != null) {
                s2CharsCountMap.put(rightBorder, borderCountRight + 1);
            } else {
                s2CharsCountMap.put(rightBorder, 1);
            }

            if(isEqMaps(s1CharsCountMap, s2CharsCountMap)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqMaps(Map<Character, Integer> one, Map<Character, Integer> two) {
        if(one.size() != two.size()) {
            return false;
        }
        for(Map.Entry<Character, Integer> entryOne :  one.entrySet()) {
            Integer countTwo = two.get(entryOne.getKey());
            if(countTwo == null || !countTwo.equals(entryOne.getValue())) {
                return false;
            }
        }
        return true;
    }
}

/* checkInclusion
    Runtime: 2302 ms, faster than 5.01% of Java online submissions for Permutation in String.
    Memory Usage: 141.5 MB, less than 5.03% of Java online submissions for Permutation in String.
*/

/* checkInclusion2
    Runtime: 21 ms, faster than 37.74% of Java online submissions for Permutation in String.
    Memory Usage: 39.8 MB, less than 46.58% of Java online submissions for Permutation in String.
*/
