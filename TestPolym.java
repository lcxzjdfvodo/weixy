package com.five;

public class TestPolym {
    public static void main(String[] args) {
        Animal a = new Animal();
        animalCry(a);
    }
    static void animalCry(Animal a) {
        a.shout();
    }

}
class Animal {
    public void shout() {
        System.out.println("叫了一声");
    }
}
class Dog extends Animal {
    public void shout() {
        System.out.println("汪汪汪");
    }

    public void seeDoor1() {
    }
}
class Cat extends Animal {
    public void shout() {
        System.out.println("喵喵喵");
    }
}
