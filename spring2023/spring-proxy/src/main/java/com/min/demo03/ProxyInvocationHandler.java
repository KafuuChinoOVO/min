package com.min.demo03;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//此类会自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this );
    }

    @Override
    //处理代理实例，兵返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //动态代理就是使用反射机制实现
        Object result = method.invoke(rent, args);
        return result;
    }

    public void seeHome(){
        System.out.println("看房");
    }

    public void fare(){
        System.out.println("收费");
    }
}
