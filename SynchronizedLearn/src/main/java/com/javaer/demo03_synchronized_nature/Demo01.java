package com.javaer.demo03_synchronized_nature;

public class Demo01 {
    public static void main(String args[]){
        new MyThread().start();
        new MyThread().start();
    }
    public static void test01(){
        synchronized (MyThread.class){
            String name = Thread.currentThread().getName();
            System.out.println(name + "进入代码4");
        }
    }

}
class MyThread extends Thread{
    @Override
    public void run(){
        synchronized (MyThread.class){
            System.out.println(getName() + "进入代码1");
            synchronized (MyThread.class){
                System.out.println(getName() + "进入代码2");
                test01();
                Demo01.test01();
            }
        }
    }

    public void test01(){
        synchronized (MyThread.class){
            System.out.println(getName() + "进入代码3");
        }
    }
}