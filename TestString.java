package com.five;

public class TestString {
    public static void main(String[] args) {
        String str="abc";
        String str1=new String("def");
        String str2="abc"+"defgh";
        String str3="18"+19;
        String str4="18"+"19";
        System.out.println(str);

        System.out.println("###########");
        String str10="wxy";
        String str11=new String("wxy");
        System.out.print(str10.equals(str11));
}
}
