package main;

import main.easy.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args){
        //Insert code here
        AddBinary obj = new AddBinary();
        System.out.println(obj.addBinary("11", "1"));
        System.out.println(obj.addBinary("1010", "1011"));
        System.out.println(obj.addBinary("0", "0"));
        System.out.println(obj.addBinary("0", "1"));
        System.out.println(obj.addBinary("1", "1"));



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
