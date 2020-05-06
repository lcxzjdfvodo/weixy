package com.four;

public class Person {
    String name;
    int age;
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
     void display() {
        System.out.println(this.age);
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        Person a=new Person(20,"肉蛋葱鸡");
        a.display();

    
    }
}
