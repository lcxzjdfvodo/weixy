package com.eight;

//测试包装类

public class TestWrappedClass {
    public static void main(String[] args) {
        //基本数据类型转化成包装类对象
        Integer a= 3;
        Integer b=Integer.valueOf(30);

        //把包装类对象转成基本数据类型
        int c=b.intValue();
        double d=b.doubleValue();

        //把字符串转化成包装类对象
        Integer e= Integer.valueOf("123456");
        Integer f=Integer.parseInt("99956265");

        //把包装类对象转成字符串
        String str=f.toString();

        //常见的常量
        System.out.println("int类型最大的整数："+Integer.MAX_VALUE);

    }
}
