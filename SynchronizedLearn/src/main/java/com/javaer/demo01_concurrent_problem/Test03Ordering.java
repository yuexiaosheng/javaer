package com.javaer.demo01_concurrent_problem;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

//@JCStressTest //表示用测试工具
//@State
//@Outcome(id = {"1", "4"}, expect = Expect.ACCEPTABLE, desc="ok")  //对输出结果的处理，如果是1和4表示是接受的
//@Outcome(id="0" , expect = Expect.ACCEPTABLE_INTERESTING,desc = "danger")//如果是保存了0，那么是接受的得感兴趣的，但是打印一个danger

public class Test03Ordering {
    private int num = 0;
    private boolean ready = false;

    //线程1执行的代码
   // @Actor //表示多线程
    public void actor1(I_Result r){ //和actor2可能命令重排，也许下面的先执行
        if(ready){
            r.r1 = num + num;
        } else {
            r.r1 = 1;
        }
    }

    //线程2执行的代码
   // @Actor
    public void actor2(I_Result r){
        num = 2;
        ready = true;  //这个地方有可能会发生指令重排，也就是a=2和flag=true互换
    }

}
