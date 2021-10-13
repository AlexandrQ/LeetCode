package main;

import main.java.easy.*;
import main.java.medium._2_AddTwoNumbers;
import main.java.medium._3_LongestSubstringWithoutRepeatingCharacters;
import main.java.medium._5_LongestPalindromicSubstring;
import main.java.medium._6_ZigZagConversion;

public class Runner {
    public static void main(String[] args){
        //Insert code here

        _6_ZigZagConversion obj = new _6_ZigZagConversion();
        //System.out.println(obj.reverseBits(00000010100101000001111010011100));
        //System.out.println(obj.reverseBits(43261596));
        //System.out.println(obj.longestPalindrome("babad"));
        System.out.println(obj.convert("PAYPALISHIRING", 4));




        /*System.out.println(obj.maxSubArray(new int[] { -2,1,-3,4,-1,2,1,-5,4 }));*/
    }
}
