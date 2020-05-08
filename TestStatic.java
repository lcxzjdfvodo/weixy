package com.four;

public class TestStatic {
    int id;
    String name;
    String pwd;

    static String company="百度";

    public TestStatic(int id,String name) {
        this.id = id;
        this.name = name;
    }
    public void login() {
        printCompany();
        System.out.println(company);
        System.out.println("登录：" + name);
    }
    public static void printCompany() {
        //login();//调用非静态成员，编译就会报错
        System.out.println(company);
    }

    public static void main(String[] args) {
        TestStatic z=new TestStatic(111,"李四");
        TestStatic.printCompany();
        TestStatic.company="腾讯";
        TestStatic.printCompany();
    }

    }

