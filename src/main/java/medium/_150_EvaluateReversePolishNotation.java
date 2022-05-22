package main.java.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

/*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
    Note that division between two integers should truncate toward zero.
    It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

    Example 1:
    Input: tokens = ["2","1","+","3","*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9

    Example 2:
    Input: tokens = ["4","13","5","/","+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6

    Example 3:
    Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    Output: 22
    Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    = ((10 * (6 / (12 * -11))) + 17) + 5
    = ((10 * (6 / -132)) + 17) + 5
    = ((10 * 0) + 17) + 5
    = (0 + 17) + 5
    = 17 + 5
    = 22

    Constraints:
    1 <= tokens.length <= 104
    tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
*/

public class _150_EvaluateReversePolishNotation {
    private static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> nums = new LinkedList<>();
        for(String str : tokens) {
            if(!OPERATORS.contains(str)) {
                nums.push(Integer.valueOf(str));
            } else {
                int secondNum = nums.pop();
                int firstNum = nums.pop();
                nums.push(calculate(firstNum, secondNum, str));
            }
        }
        return nums.pop();
    }

    private int calculate(int first, int second, String operator) {
        switch(operator) {
            case "+" : return first + second;
            case "-" : return first - second;
            case "*" : return first * second;
            case "/" : return first / second;
            default : return -1;
        }
    }
}

/*
    Runtime: 8 ms, faster than 53.13% of Java online submissions for Evaluate Reverse Polish Notation.
    Memory Usage: 44.2 MB, less than 47.68% of Java online submissions for Evaluate Reverse Polish Notation.
*/
