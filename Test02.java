package com.arrays;

public class Test02 {
    public static void main(String[] args) {
        int[] a = new int[4];
        for (int i = 0; i < a.length; i++) {
            a[i] = 100 * i;
        }
        //读取元素的值
        for (int value : a) {

            System.out.println(value);
        }
    }
}


