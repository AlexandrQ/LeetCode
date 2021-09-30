package main.java.easy;

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

    For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
    which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is
    not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making
    four. The same principle applies to the number nine, which is written as IX. There are six instances where
    subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

    Example 1:
        Input: "III"
        Output: 3
    Example 2:
        Input: "IV"
        Output: 4
    Example 3:
        Input: "IX"
        Output: 9
    Example 4:
        Input: "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.
    Example 5:
        Input: "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

import java.util.Arrays;

public class _013_RomanToInteger {

    public int romanToInt(String s) {
        int result = 0;
        char[] charsOfS = s.toCharArray();
        for(int i = 0; i < charsOfS.length; i++) {
            if (i + 1 >= charsOfS.length) {
                result += getIntValue(charsOfS[i]);
                break;
            } if (pairForSubtraction(charsOfS[i], charsOfS[i + 1])) {
                result += getSubtraction(charsOfS[i], charsOfS[i + 1]);
                i++;
            } else {
                result += getIntValue(charsOfS[i]);
            }
        }
        return result;
    }

    private boolean pairForSubtraction(char one, char two) {
        RomanNumbers eTwo = RomanNumbers.getBySymbol(two);
        switch (RomanNumbers.getBySymbol(one)) {
            case ONE:
                return eTwo.equals(RomanNumbers.FIVE) || eTwo.equals(RomanNumbers.TEN);
            case TEN:
                return eTwo.equals(RomanNumbers.FIFTY) || eTwo.equals(RomanNumbers.ONE_HUNDRED);
            case ONE_HUNDRED:
                return eTwo.equals(RomanNumbers.FIVE_HUNDRED) || eTwo.equals(RomanNumbers.ONE_THOUSAND);
            default:
                return false;
        }
    }

    private static int getSubtraction(char smallest, char largest) {
        return RomanNumbers.getBySymbol(largest).getIntValue() - RomanNumbers.getBySymbol(smallest).getIntValue();
    }

    private int getIntValue(char ch) {
        return RomanNumbers.getBySymbol(ch).getIntValue();
    }


}

enum RomanNumbers {
    ONE             ('I', 1),
    FIVE            ('V', 5),
    TEN             ('X', 10),
    FIFTY           ('L', 50),
    ONE_HUNDRED     ('C', 100),
    FIVE_HUNDRED    ('D', 500),
    ONE_THOUSAND    ('M', 1000);

    private char symbol;
    private int intValue;

    RomanNumbers(char symbol, int intValue) {
        this.symbol = symbol;
        this.intValue = intValue;
    }

    public static RomanNumbers getBySymbol(char ch) {
        return Arrays.stream(RomanNumbers.values())
                    .filter(number -> number.getSymbol() == ch)
                    .findFirst()
                    .orElse(null);
    }

    public char getSymbol() {
        return symbol;
    }

    public int getIntValue() {
        return intValue;
    }

}


    /*
        Runtime: 31 ms, faster than 5.05% of Java online submissions for Roman to Integer.
        Memory Usage: 40.4 MB, less than 45.80% of Java online submissions for Roman to Integer.
    */
