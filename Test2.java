package com.five;

class Person4 {
    private String name;
    private int age;

    public Person4() {
    }

    public Person4(String name, int age) {
        this.name = name;
        setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age > 130 || age < 0) {
            this.age = 18;
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Person[name=" + name + ",age=" + age + "]";
    }
}
public class Test2{
    public static void main(String[] args) {
        Person4 p1=new Person4();
        p1.setName("小红");
        p1.setAge(-45);
        System.out.println(p1);

        Person4 p2=new Person4("小白",300);
        System.out.print(p2);
    }
}



