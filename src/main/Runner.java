package main;

import main.easy.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args){
        //Insert code here

        _088_MergeSortedArray obj = new _088_MergeSortedArray();
        System.out.println(Arrays.toString(obj.merge(new int[] { 4, 5, 6, 0, 0, 0 }, 3, new int[] { 1, 2, 3 }, 3)));
        System.out.println(Arrays.toString(obj.merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3)));

        /*System.out.println(obj.maxSubArray(new int[] { -2,1,-3,4,-1,2,1,-5,4 }));*/
    }
}
