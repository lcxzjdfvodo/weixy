package com.eight;

/*测试StringBuilder，StringBuffer可变字符序列
 */

public class TestStringBuilder {
    public static void main(String[] args) {
        String str;

        //StringBuilder线程不安全（一般使用它），StringBuilder线程安全，效率低
        StringBuilder sb=new StringBuilder("abcdefg");

        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

        sb.setCharAt(2,'M');
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
    }
}
