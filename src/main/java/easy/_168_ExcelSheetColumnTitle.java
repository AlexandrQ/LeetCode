package main.java.easy;

/*
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

    For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...


    Example 1:

    Input: columnNumber = 1
    Output: "A"
    Example 2:

    Input: columnNumber = 28
    Output: "AB"
    Example 3:

    Input: columnNumber = 701
    Output: "ZY"
    Example 4:

    Input: columnNumber = 2147483647
    Output: "FXSHRXW"


    Constraints:

    1 <= columnNumber <= 231 - 1
*/

public class _168_ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        return methodName(columnNumber, new StringBuilder()).toString();
    }

    private StringBuilder methodName(int num, StringBuilder sb) {
        final int alphabetSize = 26;
        final int shift = 64;
        if(num > alphabetSize) {
            int remDiv = num % alphabetSize;
            if(remDiv == 0) {
                return methodName(num / alphabetSize - 1, sb).append((char)(shift + alphabetSize));
            } else {
                return methodName(num / alphabetSize, sb).append((char)(remDiv + shift));
            }
        } else {
            return sb.append((char)(num + shift));
        }
    }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
    Memory Usage: 36.2 MB, less than 72.22% of Java online submissions for Excel Sheet Column Title.
*/
