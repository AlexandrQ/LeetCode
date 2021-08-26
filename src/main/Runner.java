package main;

import main.easy.*;

public class Runner {
    public static void main(String[] args){
        //Insert code here

        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        System.out.println(obj.deleteDuplicates(RemoveDuplicatesFromSortedList.getListNodes(new int[] { 1, 1, 2 })).printAllValues());
        System.out.println(obj.deleteDuplicates(RemoveDuplicatesFromSortedList.getListNodes(new int[] { 1, 1, 2, 3, 3 })).printAllValues());

        /*System.out.println(obj.maxSubArray(new int[] { -2,1,-3,4,-1,2,1,-5,4 }));*/
    }
}
