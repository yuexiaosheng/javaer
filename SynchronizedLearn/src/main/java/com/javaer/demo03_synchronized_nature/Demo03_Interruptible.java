package com.javaer.demo03_synchronized_nature;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*目标：演示Lock的不可中断和可中断*/
public class Demo03_Interruptible {
    private static Lock lock = new ReentrantLock();

    //psvm
    public static void main(String[] args) throws InterruptedException {
            //test01();
            test02();
    }
    public static void test02() throws InterruptedException {
        Runnable run = () -> {
            String name = Thread.currentThread().getName();
            boolean b= false;
            try{
                b = lock.tryLock(3, TimeUnit.SECONDS); //可以中断，等不到就干别的
                //lock.lock(); //不可中断，一直等锁
                if(b) {
                    System.out.println(name + "获取锁，进入锁执行");
                    Thread.sleep(888888);
                }else{
                    System.out.println(name + "指定时间内没得到锁，去干别的");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(b) {
                    lock.unlock();
                    System.out.println(name + "释放锁");
                }

            }

        };

        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(run);
        t2.start();

//        System.out.println("停止t2线程前");
//        t2.interrupt();
//        System.out.println("停止t2线程后");
//
//        Thread.sleep(1000);
//        System.out.println(t1.getState());
//        System.out.println(t2.getState());

    }

    public static void test01() throws InterruptedException {
        Runnable run = () -> {
            String name = Thread.currentThread().getName();
            try{
                lock.lock(); //不可中断，一直等锁
                System.out.println(name + "获取锁，进入锁执行");
                Thread.sleep(888888);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(name + "释放锁");
            }

        };

        Thread t1 = new Thread(run);
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(run);
        t2.start();

        System.out.println("停止t2线程前");
        t2.interrupt();
        System.out.println("停止t2线程后");

        Thread.sleep(1000);
        System.out.println(t1.getState());
        System.out.println(t2.getState());

    }
}
