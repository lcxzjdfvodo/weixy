package com.arrays;

import java.util.Arrays;

public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 10};
        Arrays.sort(arr);//二分查找之前，一定要对数组进行排序

       System.out.println(Arrays.toString(arr));
       System.out.println(myBinarySearch(arr,10));
    }

    public static int myBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;

            if (value == arr[mid]) {
                return mid;
            }
            if (value > arr[mid]) {
               low=mid+1;
            }
            if(value<arr[mid]){
                high=mid-1;
            }
        }
        return -1;
    }
}


