package com.four;

public class TestThis2 {
    int a,b,c;

    TestThis2() {
        System.out.println("正要初始化一个Hello对象");
    }
    TestThis2(int a,int b) {
        this();//调用无参的构造方法，并且必须位于第一行
        a = a;//这里都是指的局部变量而不是成员变量
        //这样就区分了成员变量和局部变量，这种情况占了this使用情况大多数
        this.a = a;
        this.b = b;
    }
    TestThis2(int a,int b,int c) {
        this(a, b);//调用带参的构造方法，并且必须位于第一行
        this.c = c;
    }

    void sing() {
    }
    void eat() {
        this.sing();//调用本类中的sing(); 可以不用
        System.out.println("这波啊，这波是肉蛋葱鸡！");
    }
    public static void main(String[] args){
        TestThis2 w=new TestThis2(2,3);
        w.eat();


    }

}