package main.java.medium;

/*
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    Example 2:
    Input: digits = ""
    Output: []

    Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]

    Constraints:
    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].
*/

import java.util.*;

public class _17_LetterCombinationsOfPhoneNumber {
    private static final Map<Integer, List<String>> LETTERS;

    static {
        LETTERS = new HashMap<>();
        LETTERS.put(2 , Arrays.asList("a", "b", "c"));
        LETTERS.put(3 , Arrays.asList("d", "e", "f"));
        LETTERS.put(4 , Arrays.asList("g", "h", "i"));
        LETTERS.put(5 , Arrays.asList("j", "k", "l"));
        LETTERS.put(6 , Arrays.asList("m", "n", "o"));
        LETTERS.put(7 , Arrays.asList("p", "q", "r", "s"));
        LETTERS.put(8 , Arrays.asList("t", "u", "v"));
        LETTERS.put(9 , Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        return getCombinations(digits);
    }
    
    private List<String> getCombinations(String digits) {
        if(digits.length() == 1) {
            return LETTERS.get(Integer.valueOf(digits));
        }
        List<String> fromCurrentNum = LETTERS.get(Integer.valueOf(digits.charAt(0) + ""));
        List<String> fromTail = getCombinations(digits.substring(1));
        List<String> result = new ArrayList<>();
        for(String current : fromCurrentNum) {
            for(String tail : fromTail) {
                result.add(current + tail);
            }
        }
        return result;
    }
}

/*
    Runtime: 3 ms, faster than 47.31% of Java online submissions for Letter Combinations of a Phone Number.
    Memory Usage: 39.4 MB, less than 36.16% of Java online submissions for Letter Combinations of a Phone Number.
*/
