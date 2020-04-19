package com.arrays;

import java.util.Arrays;

public class TestArrayTableData {
    public static void main(String[] args) {
        Object[] emp1={1001,"张三","12","上单","2018.2.31"};
        Object[] emp2={1223,"古拉加斯","40","打野","2012.3.4"};
        Object[] emp3={3345,"辛德拉","28","中单","2016,6,21"};

        Object[][]tableData=new Object[3][];
        tableData[0]=emp1;
        tableData[1]=emp2;
        tableData[2]=emp3;

        for(Object[] temp:tableData){
            System.out.println(Arrays.toString(temp));
        }
    }
}
