package main.java.easy;

/*
    Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

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
    Input: columnTitle = "A"
    Output: 1

    Example 2:
    Input: columnTitle = "AB"
    Output: 28

    Example 3:
    Input: columnTitle = "ZY"
    Output: 701

    Example 4:
    Input: columnTitle = "FXSHRXW"
    Output: 2147483647

    Constraints:

    1 <= columnTitle.length <= 7
    columnTitle consists only of uppercase English letters.
    columnTitle is in the range ["A", "FXSHRXW"].
*/

public class _171_ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        final int alphabetSize = 26;
        final int shift = 64;
        int rez = 0;
        for(int i = 0; i < columnTitle.length(); i++) {
            int ch = columnTitle.charAt(columnTitle.length() - i - 1) - shift;
            rez += Math.pow(alphabetSize, i) * ch;
        }
        return rez;
    }
}

/*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Number.
    Memory Usage: 38.9 MB, less than 78.91% of Java online submissions for Excel Sheet Column Number.
*/
