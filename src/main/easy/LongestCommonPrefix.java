package main.easy;

/*
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:

    Input: ["flower","flow","flight"]
    Output: "fl"
    Example 2:

    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
    Note:

    All given inputs are in lowercase letters a-z.
*/

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        for(String str : strs) {
            if(commonPrefix.length() == 0 || str.length() == 0) {
                return "";
            }
            for(int i = 0; i < Math.min(commonPrefix.length(), str.length()); i++) {
                if(commonPrefix.charAt(i) != str.charAt(i)) {
                    if(i == 0) {
                        return "";
                    } else {
                        commonPrefix = str.substring(0, i);
                        break;
                    }
                } else if (i == str.length() - 1) {
                    commonPrefix = str;
                }
            }
        }
        return commonPrefix;
    }
}

/*
    Runtime: 1 ms, faster than 70.73% of Java online submissions for Longest Common Prefix.
    Memory Usage: 37.5 MB, less than 79.78% of Java online submissions for Longest Common Prefix.
*/
