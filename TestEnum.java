package com.eight;
//测试枚举
public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);

        Season a=Season.WINTER;

        switch(a){
            case SPRING:
                System.out.println("春天来了");
                break;
            case SUMMER:
                System.out.println("夏天来了");
                break;
            case AUTUMN:
                System.out.println("秋天来了");
                break;
            case WINTER:
                System.out.println("冬天来了");
                break;
        }
    }
}
enum Season{
    SPRING,SUMMER,AUTUMN,WINTER
}