package com.arrays;

import java.util.Arrays;

public class TestBubbleSort {
    public static void main(String[] args) {

        int[] value={3,1,6,2,0,9,7,4,5,8};
        int temp=0;
        for(int i=0;i<value.length-1;i++){
            boolean flag=true;
            /*在每一次的大循环里设置一个变量flag，如果小循环继续发生交换，则说明没排好，是false，
              如果不发生交换则说明排好了，为true。
              这是对冒泡排序的优化。
             */

            for(int j=0;j<value.length-1-i;j++) {
                //比较大小，换顺序
                if (value[j] > value[j + 1]) {
                    temp = value[j];
                    value[j] = value[j + 1];
                    value[j + 1] = temp;

                    flag = false;
                }

                System.out.println(Arrays.toString(value));
            }
            if(flag){
                System.out.println("结束了！！！");
                break;

            }


            System.out.println("###########");
        }
    }
}
