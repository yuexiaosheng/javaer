package com.javaer.dynamic;

import com.javaer.proxy.House1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------买房前申请房产审批");
        Object invoke = method.invoke(object, args);
        System.out.println("------买房后拿到房本");
        return invoke;
    }
    public static void main(String[] args) {
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        House1 house1 = new House1();
        InvocationHandler invocationHandler = new MyInvocationHandler(house1);
        House dynamicProxy = (House) Proxy.newProxyInstance(House1.class.getClassLoader(),
                House1.class.getInterfaces(), invocationHandler);
        dynamicProxy.buy();

        Shop shop100 = new Shop100();
        invocationHandler = new MyInvocationHandler(shop100);
        Shop dynamicProxyShop = (Shop) Proxy.newProxyInstance(Shop100.class.getClassLoader(),
                Shop100.class.getInterfaces(), invocationHandler);
        dynamicProxyShop.buy();
        System.out.println("房子代理" + dynamicProxy.getClass());
        System.out.println("商铺代理" + dynamicProxyShop.getClass());

    }
}
