package com.javaer.demo07_biased_lock;

import org.openjdk.jol.info.ClassLayout;

public class Demo01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        MyThread myThread2 = new MyThread();
        myThread2.start();
//        Object obj2 = new Object();
//        System.out.println(ClassLayout.parseInstance(obj2).toPrintable());
    }
}
class MyThread extends Thread{
    static Object obj = new Object();
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            synchronized (obj){
                System.out.println(ClassLayout.parseInstance(obj).toPrintable());
            }
        }
    }
}
