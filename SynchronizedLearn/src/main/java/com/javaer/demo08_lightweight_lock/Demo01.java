package com.javaer.demo08_lightweight_lock;

import org.openjdk.jol.info.ClassLayout;

public class Demo01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        
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
