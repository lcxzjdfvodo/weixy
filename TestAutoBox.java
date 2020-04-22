package com.eight;

//测试装箱
public class TestAutoBox {
    public static void main(String[] args) {
        Integer a=234;//自动装箱，Integer a=Integer valueOf（234）；
        int b=a;//自动拆箱，编译器会修改成int b=aintValue();

        Integer c=null;
        //if(c!=null){
            //int d=c;//自动拆箱：调用了：c.intValue()
       // }

        //缓存[-128,127]之间的数字
        Integer in1=Integer.valueOf(-128);
        Integer in2=-128;
        System.out.println(in1==in2);
        System.out.println(in1.equals(in2));
        System.out.println("####################");
        Integer in3=1234;
        Integer in4=1234;
        System.out.println(in3==in4);
        System.out.println(in3.equals(in4));

     //实际就是系统初始的时候，创建了【-128，127】之间的一个循环数组。
     //当我们调用valueOf的时候，首先检查是否在【-128，127】之间，如果在这个范围内则直接从缓存数组中拿出已经建好的对象
     //如果不在这个范围，则创建新的integer对象
    }
}
