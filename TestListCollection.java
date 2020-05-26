package com.nine;
//测试Collection接口中的方法

import java.util.ArrayList;
import java.util.Collection;

public class TestListCollection {
    public static void main(String[] args) {
        Collection<String>c=new ArrayList<>();

        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("王者");
        c.add("张三");
        System.out.println(c);
        System.out.println(c.size());

        System.out.println(c.contains("张三"));

        Object[] objs=c.toArray();
        System.out.println(objs);

        c.remove("张三");
        System.out.println(c);

        c.clear();
        System.out.println(c.size());

    }
}
