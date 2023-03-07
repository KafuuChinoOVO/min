package com.min.demo01;

public class Proxy implements Rent {
    private Host host;
    public Proxy(){

    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
        seeHouse();
        hetong();
        fare();
    }

    public void seeHouse(){
        System.out.println("看房");
    }

    public void hetong(){
        System.out.println("合同");
    }

    public void fare(){
        System.out.println("收费");
    }

}
