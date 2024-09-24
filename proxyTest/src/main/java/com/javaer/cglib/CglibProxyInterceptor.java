package com.javaer.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("买房前申请房产证");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("买房后得到房产证");
        return object;
    }
    public static void main(String[] args) {
        // //在指定目录下生成动态代理类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/ge/ge/web/my_java/javaer/proxyTest/cglib/");
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(House.class);
        //设置回调函数
        enhancer.setCallback(new CglibProxyInterceptor());
        //这里的creat方法就是正式创建代理类
        House house = (House)enhancer.create();
        //调用代理类的play方法
        house.buy();
        System.out.println("cglib动态代理House："+house.getClass());
    }

}

