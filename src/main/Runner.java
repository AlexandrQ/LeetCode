package main;

import main.easy.PalindromeNumber;
import main.easy.ReverseInteger;
import main.easy.RomanToInteger;
import main.easy.TwoSum;

public class Runner {
    public static void main(String[] args){
        //Insert code here
        RomanToInteger obj = new RomanToInteger();
        System.out.println(obj.romanToInt("IXIX"));
        System.out.println(obj.romanToInt("IV"));
        System.out.println(obj.romanToInt("XL"));
        System.out.println(obj.romanToInt("CM"));
        System.out.println(obj.romanToInt("I"));
        System.out.println(obj.romanToInt("II"));
        System.out.println(obj.romanToInt("III"));
        System.out.println(obj.romanToInt("LVIII"));
        System.out.println(obj.romanToInt("MCMXCIV"));
    }
}
