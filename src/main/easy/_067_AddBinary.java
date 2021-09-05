package main.easy;

/*
    Given two binary strings a and b, return their sum as a binary string.

    Example 1:

    Input: a = "11", b = "1"
    Output: "100"
    Example 2:

    Input: a = "1010", b = "1011"
    Output: "10101"

    Constraints:

    1 <= a.length, b.length <= 104
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.
*/

public class _067_AddBinary {
    public String addBinary(String a, String b) {
        final char ZERO_CHAR = '0';
        final char ONE_CHAR = '1';
        int additional = 0;
        StringBuilder result = new StringBuilder();
        for(int index = 0; index < (Math.max(a.length(), b.length())); index++) {
            if(equalsChar(a, index, ONE_CHAR) && equalsChar(b, index, ONE_CHAR) && additional > 0) {
                result.append(ONE_CHAR);
            } else if(equalsChar(a, index, ONE_CHAR) && equalsChar(b, index, ONE_CHAR) && additional == 0) {
                additional++;
                result.append(ZERO_CHAR);
            } else if((equalsChar(a, index, ONE_CHAR) || equalsChar(b, index, ONE_CHAR)) && additional > 0){
                result.append(ZERO_CHAR);
            } else if(equalsChar(a, index, ONE_CHAR) || equalsChar(b, index, ONE_CHAR)){
                result.append(ONE_CHAR);
            } else if(equalsChar(a, index, ZERO_CHAR) && equalsChar(b, index, ZERO_CHAR) && additional > 0) {
                additional--;
                result.append(ONE_CHAR);
            } else if(additional > 0) {
                additional--;
                result.append(ONE_CHAR);
            } else {
                result.append(ZERO_CHAR);
            }
        }

        if(additional > 0) {
            result.append("1".repeat(additional));
        }
        return result.reverse().toString();
    }

    private boolean equalsChar(String str, int index, char ch) {
        if(str.length() - index - 1 < 0) {
            return false;
        } else {
            return str.charAt(str.length() - index - 1) == ch;
        }
    }
}

/*
    Runtime: 2 ms, faster than 70.67% of Java online submissions for Add Binary.
    Memory Usage: 37.7 MB, less than 96.25% of Java online submissions for Add Binary.
*/
