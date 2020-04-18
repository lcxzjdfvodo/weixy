package com.arrays;

public class Test2DimensionArray {
    public static void main(String[] args) {

        int[][] a=new int[3][];

        a[0]=new int[]{20,30};
        a[1]=new int[]{10,28,83};
        a[2]=new int[]{23,42};

        System.out.println(a[1][2]);


        int[][] b={
                {20,30,40},
                {32,2232,121},
                {2323,12,34,12}
        };
        System.out.println(b[2][3]);
    }
}
