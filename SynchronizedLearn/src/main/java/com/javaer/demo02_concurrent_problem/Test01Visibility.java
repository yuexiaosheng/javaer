package com.javaer.demo02_concurrent_problem;




public class Test01Visibility {
    //定义共享变量
    //private static volatile boolean flag = true;
    private static  boolean flag = true;
    private static Object obj = new Object();
    public  static  void main(String[] args) throws InterruptedException
    {
        //2.创建一个线程不停地读取共享变量
        new Thread(()->{
            while(flag){
//                synchronized (obj){
//
//                }
                System.out.println(flag);

            }
        }).start();

        Thread.sleep(2000);

        //3. 并发线程修改flag为false
        new Thread(()->{
            flag = false;
            System.out.println("线程修改了变量flag为false");
        }).start();

    }
}
