package main;

import main.easy.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args){
        //Insert code here

        _136_SingleNumber obj = new _136_SingleNumber();
        System.out.println(obj.singleNumber(new int[] { 2,2,1 }));
        System.out.println(obj.singleNumber(new int[] { 4,1,2,1,2 }));
        System.out.println(obj.singleNumber(new int[] { 4,4,1,2,1,0,0,8,2 }));


        /*System.out.println(obj.maxSubArray(new int[] { -2,1,-3,4,-1,2,1,-5,4 }));*/
    }
}
