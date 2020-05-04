package com.four;

import static java.lang.Math.*;
public class Circle {
    double r;
    public Circle(double r) {
        this.r = r;
    }
    public void gerArea() {
        double area =PI*r*r;
        System.out.println("圆的面积为：" + area);
    }
    public void getPerimeter() {
        double perimeter = 2 *PI* r;
        System.out.println("圆的周长为：" + perimeter);
    }

    public static void main(String[] args) {
        Circle a=new Circle(4.00);
        a.gerArea();
        a.getPerimeter();
    }


}


