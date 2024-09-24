package com.javaer.demo05_cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 目标：演示原子性问题
 * 1. 定义一共一
 * 2. 对number 进行1000次++
 * 3. 用5个线程来进行 5.fori
 */
class Demo1 {
    //1. 定义共享变量
    private static AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        //2. 对number 进行1000次++
        Runnable increment = () -> {
            for(int i=0 ;i < 1000; i++){
                atomicInteger.incrementAndGet() ;
            }
        };

        List<Thread> list = new ArrayList<>();

        //3. 用5个线程来进行 idea快捷键 5.fori
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(increment);
            t.start();
            list.add(t);
        }

        // 快捷键 list.for t.join 为了等五个线程跑完，在执行下面的print
        for (Thread t : list) {
            t.join();
        }
        System.out.println("number " + atomicInteger.get());
        //有可能五个线程没跑完，就执行了主线程，为了等五个跑完，所以用join
        //结果是多跑几次，number不一定等于5000
    }
}
