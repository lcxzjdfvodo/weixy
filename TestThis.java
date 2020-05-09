package com.four;

public class TestThis {
    int id;
    String name;
    String pwd;

    public TestThis() {
    }

    public TestThis(int id, String name) {
        System.out.println("正在初始化已经创建好的对象：" + this);
        this.id = id; //不写this，无法区分局部变量id和成员变量id
        this.name = name;
    }

    public void login() {
        System.out.println(this.name + ",要登录！");//不写效果一样
    }

    public static void main(String[] args) {
        TestThis t3 = new TestThis(123, "张三");
        System.out.println("打印张三对象：" + t3);
        t3.login();
    }
}

