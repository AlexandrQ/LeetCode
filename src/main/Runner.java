package main;

import main.easy.*;

public class Runner {
    public static void main(String[] args){
        //Insert code here
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid("()"));
        System.out.println(obj.isValid("()[]{}"));
        System.out.println(obj.isValid("(]"));
        System.out.println(obj.isValid("([)]"));
        System.out.println(obj.isValid("{[]}"));
    }
}
