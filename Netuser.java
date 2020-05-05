package com.four;

public class Netuser {
    int id;
    int pwd;
    String emailAddr;

    public Netuser(int id, int pwd) {
        this.id = id;
        this.pwd = pwd;
        emailAddr = this.id + "@gameschool.com";
    }
    public Netuser(int id, int pwd, String emailAddr) {
        this.id=id;
        this.pwd=pwd;
        this.emailAddr = emailAddr;
    }
    public void Test() {
        System.out.println(id + "\t" + pwd + "\t" + emailAddr);
    }
    public static void main(String[] args) {
        Netuser n=new Netuser(123456,1231);
        Netuser n1=new Netuser(123456,4321,"76543@123.com");
        n.Test();
        n1.Test();
    }
    }

