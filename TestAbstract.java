package com.five;

abstract  class Animal1 {
    abstract public void shout1();
}
class Dog1 extends Animal1 {
    public void shout1() {
        System.out.println("汪汪汪");
    }

    public void seeDoor1() {
        System.out.println("看门中");
    }
}
public class TestAbstract{
    public static void main(String[] args) {
        Dog1 l=new Dog1();
        l.shout1();
        l.seeDoor1();
    }
    }




