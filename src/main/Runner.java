package main;

import main.easy.*;

public class Runner {
    public static void main(String[] args){
        //Insert code here
        LengthOfLastWord obj = new LengthOfLastWord();
        System.out.println(obj.lengthOfLastWord("Hello World"));
        System.out.println(obj.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(obj.lengthOfLastWord("luffy is still joyboy"));


        /*System.out.println(obj.maxSubArray(new int[] { -2,1,-3,4,-1,2,1,-5,4 }));
        System.out.println(obj.maxSubArray(new int[] { 1 }));
        System.out.println(obj.maxSubArray(new int[] { 5,4,-1,7,8 }));
        System.out.println(obj.maxSubArray(new int[] { -2,-1 }));
        System.out.println(obj.maxSubArray(new int[] { 2,-3,0,3 }));
        System.out.println(obj.maxSubArray(new int[] { 2,-1,-3,-1,3,0,-1,-3,3,0 }));
        System.out.println(obj.maxSubArray(new int[] { 3,-2,-3,-3,1,3,0 }));
        System.out.println(obj.maxSubArray(new int[] { -3,-2,0,-1 }));*/
    }
}
