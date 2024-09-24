package com.javaer.demo01_concurrent_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标：演示原子性问题
 * 1. 定义一共一
 * 2. 对number 进行1000次++
 * 3. 用5个线程来进行 5.fori
 */
public class Test02Atomicity {
    //1. 定义共享变量
    private static int number = 0;
    public static void main(String[] args) throws InterruptedException {
        //2. 对number 进行1000次++
        Runnable increment = () -> {
            for(int i=0 ;i < 1000; i++){
                number ++ ;
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
        System.out.println("number " + number);
        //有可能五个线程没跑完，就执行了主线程，为了等五个跑完，所以用join
        //结果是多跑几次，number不一定等于5000
    }
}
