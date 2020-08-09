package com.DES.operation;

public class Threadabc {
    new Thread(new Thread1()).start();
    new Thread(new Thread2()).start();
}
}
class ThreadResource{
    public static Object resource1=new Object();
    public static Object resource2=new Object();

}

class Thread1 implements Runnable{
    @Override
    public void run(){
        try{
            System.out.println("run");
            synchronized (ThreadResource.resource1){
                System.out.println("lock resource1");
                Thread.sleep(1000);
                synchronized (ThreadResource.resource2){
                    System.out.println("1 release 2");
                }
            }
    }
}