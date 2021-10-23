package main.java.medium;

/*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given an integer, convert it to a roman numeral.

    Example 1:
    Input: num = 3
    Output: "III"

    Example 2:
    Input: num = 4
    Output: "IV"

    Example 3:
    Input: num = 9
    Output: "IX"

    Example 4:
    Input: num = 58
    Output: "LVIII"
    Explanation: L = 50, V = 5, III = 3.

    Example 5:
    Input: num = 1994
    Output: "MCMXCIV"
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    Constraints:
    1 <= num <= 3999
*/

import com.sun.source.tree.CaseTree;

import java.util.HashMap;
import java.util.Map;

public class _12_IntegerToRoman {
    private static final Map<Integer, String> NUMS;
    private static final Map<Integer, String> TAILS;
    private static final int[] ARR = {5, 50, 500};

    static {
        NUMS = new HashMap<>();
        NUMS.put(1, "I");
        NUMS.put(5, "V");
        NUMS.put(10, "X");
        NUMS.put(50, "L");
        NUMS.put(100, "C");
        NUMS.put(500, "D");
        NUMS.put(1000, "M");

        TAILS = new HashMap<>();
        TAILS.put(1000, "C");
        TAILS.put(500, "C");
        TAILS.put(100, "X");
        TAILS.put(50, "X");
        TAILS.put(10, "I");
        TAILS.put(5, "I");
    }
    public String intToRoman(int num) {
        return convert(num);
    }

    private String convert(int num) {
        int nearest = getNearestInt(num);
        int full = num / nearest;
        int rem = num % nearest;
        String tailStr = "";
        String remStr = "";
        if(rem != 0 && rem >= getBorder(nearest)) {
            tailStr = TAILS.get(nearest) + NUMS.get(nearest);
            rem -= getBorder(nearest);
        }
        if(rem != 0) {
            remStr = convert(rem);
        }
        String fullStr = full > 0 ? NUMS.get(nearest) : "";
        for(int i = 1; i < full; i++) {
            fullStr += getAdditional(nearest);
        }
        return fullStr + tailStr + remStr;
    }

    private int getNearestInt(int num) {
        if(num >= 900) {
            return 1000;
        } else if(num >= 400) {
            return 500;
        } else if(num >= 90) {
            return 100;
        } else if(num >= 40) {
            return 50;
        } else if(num >= 9) {
            return 10;
        } else if(num >= 4) {
            return 5;
        } else {
            return 1;
        }
    }

    private String getAdditional(int num) {
        if(num == 1000) {
            return NUMS.get(num);
        } else if(num == 500) {
            return TAILS.get(num);
        } else if(num == 100) {
            return NUMS.get(num);
        } else if(num == 50) {
            return TAILS.get(num);
        } else if(num == 10) {
            return NUMS.get(num);
        } else if(num == 5) {
            return TAILS.get(num);
        } else if(num == 1) {
            return NUMS.get(num);
        } else {
            return "";
        }
    }

    private int getBorder(int num) {
        return switch (num) {
            case (1000) -> 900;
            case (100) -> 90;
            case (10) -> 9;
            case (500) -> 400;
            case (50) -> 40;
            case (5) -> 4;
            default -> 0;
        };
    }
}

/*
Runtime: 25 ms
Memory Usage: 43.7 MB
*/





















