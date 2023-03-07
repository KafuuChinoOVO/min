package com.min.demo01;

public class Client {
    public static void main(String[] args) {
        //房东租房
        Host host = new Host();
        //代理，中介租房，附加附加操作
        Proxy proxy = new Proxy(host);
        //不需要找房东，找中介
        proxy.rent();
    }
}
