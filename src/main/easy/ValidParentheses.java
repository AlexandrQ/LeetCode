package main.easy;

    /*
        Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:
            Open brackets must be closed by the same type of brackets.
            Open brackets must be closed in the correct order.

        Example 1:
            Input: s = "()"
            Output: true
        Example 2:
            Input: s = "()[]{}"
            Output: true
        Example 3:
            Input: s = "(]"
            Output: false
        Example 4:
            Input: s = "([)]"
            Output: false
        Example 5:
            Input: s = "{[]}"
            Output: true

        Constraints:
            1 <= s.length <= 104
            s consists of parentheses only '()[]{}'.
    */

import java.util.*;

public class ValidParentheses {
    public static final Map<Character, Character> parentheses = new HashMap<>(3);
    {
        parentheses.put(')', '(');
        parentheses.put('}', '{');
        parentheses.put(']', '[');
    }
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for(Character ch : s.toCharArray()) {
            if(parentheses.containsValue(ch)) {
                deque.add(ch);
            } else {
                Character fromDeque = deque.pollLast();
                if(Objects.isNull(fromDeque) ||
                        !fromDeque.equals(parentheses.get(ch))) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}

    /*
        Runtime: 1 ms, faster than 99.06% of Java online submissions for Valid Parentheses.
        Memory Usage: 37.8 MB, less than 50.75% of Java online submissions for Valid Parentheses.
     */
