package main.easy;

    /*
        Implement strStr().

        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

        Clarification:

        What should we return when needle is an empty string? This is a great question to ask during an interview.

        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

        Example 1:

        Input: haystack = "hello", needle = "ll"
        Output: 2
        Example 2:

        Input: haystack = "aaaaa", needle = "bba"
        Output: -1
        Example 3:

        Input: haystack = "", needle = ""
        Output: 0

        Constraints:

        0 <= haystack.length, needle.length <= 5 * 104
        haystack and needle consist of only lower-case English characters.
    */


public class _028_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        if(arr2.length == 0) {
            return 0;
        }
        if(arr1.length < arr2.length) {
            return -1;
        }
        int countMatch = 0;
        int firstIndex = 0;
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j]) {
                    countMatch++;
                    if(j == 0) {
                        firstIndex = i;
                    }
                } else {
                    if(countMatch > 0) {
                        i = firstIndex;
                    }
                    countMatch = 0;
                    break;
                }
                if(i+1 < arr1.length) {
                    i++;
                }
            }
            if(countMatch == arr2.length) {
                return firstIndex;
            }
        }
        return -1;
    }
}

    /*
        Runtime: 1310 ms, faster than 8.29% of Java online submissions for Implement strStr().
        Memory Usage: 38.6 MB, less than 36.22% of Java online submissions for Implement strStr().
     */
