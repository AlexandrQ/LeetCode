package main;

import main.easy.*;

public class Runner {
    public static void main(String[] args){
        //Insert code here
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] strs = {"abab","aba", ""};
        System.out.println(obj.longestCommonPrefix(strs));
    }
}
