package main;

import main.easy.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args){
        //Insert code here
        PlusOne obj = new PlusOne();
        System.out.println(Arrays.toString(obj.plusOne(new int[] { 1, 2, 3 })));
        System.out.println(Arrays.toString(obj.plusOne(new int[] { 4,3,2,1 })));
        System.out.println(Arrays.toString(obj.plusOne(new int[] { 0 })));
        System.out.println(Arrays.toString(obj.plusOne(new int[] { 9 })));
        System.out.println(Arrays.toString(obj.plusOne(new int[] { 9, 9, 9 })));


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
