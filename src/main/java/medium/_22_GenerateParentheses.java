package main.java.medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]

    Example 2:
    Input: n = 1
    Output: ["()"]

    Constraints:
    1 <= n <= 8
*/

public class _22_GenerateParentheses {
    private List<String> parenthesesList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(n, n, "");
        return parenthesesList;
    }

    private void generate(int openParCount, int closeParCount, String res) {
        if(openParCount > 0) {
            generate(openParCount - 1, closeParCount, res + "(");
        }
        if(closeParCount > 0 && closeParCount > openParCount) {
            generate(openParCount, closeParCount - 1, res + ")");
        }
        if(openParCount == 0 && closeParCount == 0) {
            parenthesesList.add(res);
        }
    }
}

/*
    Runtime: 1 ms, faster than 78.78% of Java online submissions for Generate Parentheses.
    Memory Usage: 39.3 MB, less than 62.87% of Java online submissions for Generate Parentheses.
*/
